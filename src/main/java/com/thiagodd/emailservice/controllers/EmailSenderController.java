package com.thiagodd.emailservice.controllers;

import com.thiagodd.emailservice.application.EmailSenderService;
import com.thiagodd.emailservice.core.EmailRequest;
import com.thiagodd.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailSenderController {

    private final EmailSenderService senderService;

    @Autowired
    public EmailSenderController(EmailSenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.senderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email send successfully");
        } catch (EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email...");
        }
    }
}
