package com.kaiasia.mailservice.service.impl;

import com.kaiasia.mailservice.model.MessageDTO;
import com.kaiasia.mailservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements EmailService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(MessageDTO messageDTO) {
        try {
            log.info("START ... Sending email");
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
            helper.setTo(messageDTO.getTo());
            helper.setSubject(messageDTO.getSubject());
            helper.setText(messageDTO.getContent());
            mailSender.send(mimeMessage);
            log.info("END ... Email sent successfully");
        } catch (MessagingException e) {
            log.error("Email sent with error", e.getMessage());
        }

    }
}
