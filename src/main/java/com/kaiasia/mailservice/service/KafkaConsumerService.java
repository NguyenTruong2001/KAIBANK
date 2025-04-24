package com.kaiasia.mailservice.service;

import com.kaiasia.mailservice.model.MessageDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ConsumerFactory<String, Object> consumerFactory;
    private final EmailService emailService;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private ExecutorService executorService;

    public KafkaConsumerService(final ConsumerFactory<String, Object> consumerFactory, final EmailService emailService) {
        this.consumerFactory = consumerFactory;
        this.emailService = emailService;
    }

    @PostConstruct
    public void pollMessages() {
        logger.info("Starting Kafka Consumer Service");

        // Tạo một blocking queue được chia sẻ cho các tin nhắn
        BlockingQueue<ConsumerRecord<String, Object>> queue = new LinkedBlockingQueue<>();

        // Khởi động thread consumer lấy từ Kafka và đưa vào queue
        executorService = Executors.newFixedThreadPool(4); // 1 consumer + 3 workers
        executorService.submit(() -> {
            KafkaConsumer<String, Object> consumer = (KafkaConsumer<String, Object>) consumerFactory.createConsumer();
            consumer.subscribe(Collections.singletonList("getOTP"));

            try {
                while (running.get()) {
                    ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord<String, Object> record : records) {
                        queue.put(record); // Sẽ block nếu queue đầy
                    }
                    consumer.commitSync();
                }
            } catch (Exception e) {
                logger.error("Lỗi trong thread consumer Kafka", e);
            } finally {
                consumer.close();
            }
        });

        // Khởi động các worker thread xử lý từ queue
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    while (running.get()) {
                        try {
                            ConsumerRecord<String, Object> record = queue.take(); // Sẽ block cho đến khi có record
                            logger.info("Đang xử lý tin nhắn từ topic: {}", record.topic());

                            String messageJson = (String) record.value();
                            JSONObject json = new JSONObject(messageJson);

                            MessageDTO messageDTO = new MessageDTO();
                            messageDTO.setTo(json.optString("email", "no-reply@example.com"));
                            messageDTO.setSubject(json.optString("subject", "Default Subject"));
                            messageDTO.setContent(json.optString("content", "No content"));

                            emailService.sendEmail(messageDTO);
                        } catch (Exception e) {
                            logger.error("Lỗi khi xử lý tin nhắn", e);
                        }
                    }
                } catch (Exception e) {
                    logger.error("Lỗi thread worker", e);
                }
            });
        }
    }

    // Phương thức để tắt service một cách nhẹ nhàng
    public void shutdown() {
        running.set(false);
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}