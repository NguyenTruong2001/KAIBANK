package com.kaiasia.app.repository;

import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.entity.NapasTransaction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBService {
    private static final Random random = new Random();
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ITransactionDAO transactionDAO;

    public DBService() {
    }

    public static synchronized String generateTransactionRef() {
        int dayOfYear = LocalDate.now().get(ChronoField.DAY_OF_YEAR);
        String dayPart = String.format("%03d", dayOfYear);
        String randomPart = generateRandomLetters(4);
        long timestamp = System.currentTimeMillis();
        return String.format("%s%s%d", dayPart, randomPart, timestamp);
    }

    private static String generateRandomLetters(int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            char randomChar = (char)(65 + random.nextInt(26));
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public NapasTransaction checkDup(String transRef) {
        try {
            return this.transactionDAO.getByRef(transRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String insertTransaction(Transaction transaction) throws Exception {
        NapasTransaction napasTransaction = new NapasTransaction();
        napasTransaction.setSenderAccount(transaction.getSenderAccount());
        napasTransaction.setAmount(transaction.getAmount());
        napasTransaction.setCcy(transaction.getCcy());
        napasTransaction.setTransRef(transaction.getTransRef());
        napasTransaction.setBenAcc(transaction.getBenAcc());
        napasTransaction.setBankId(transaction.getBankId());
        napasTransaction.setTransContent(transaction.getTransContent());
        napasTransaction.setNapasRef(generateTransactionRef());
        napasTransaction.setTimeUpdate(LocalDateTime.now());
        if ("003".equals(transaction.getBenAcc())) {
            return null;
        } else {
            if ("002".equals(transaction.getBenAcc())) {
                try {
                    Thread.sleep(60000L);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            return this.transactionDAO.insert(napasTransaction) > 0 ? napasTransaction.getNapasRef() : null;
        }
    }
}

