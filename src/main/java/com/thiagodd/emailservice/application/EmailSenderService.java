package com.thiagodd.emailservice.application;

import com.thiagodd.emailservice.adapters.EmailSenderGateway;
import com.thiagodd.emailservice.core.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSendergateway;

    public EmailSenderService(EmailSenderGateway emailGateway){
        this.emailSendergateway = emailGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSendergateway.sendEmail(to, subject, body);
    }
}
