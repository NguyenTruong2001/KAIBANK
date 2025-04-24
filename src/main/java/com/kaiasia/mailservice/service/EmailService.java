package com.kaiasia.mailservice.service;

import com.kaiasia.mailservice.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO message);
}
