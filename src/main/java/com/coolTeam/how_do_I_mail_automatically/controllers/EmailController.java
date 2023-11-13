package com.coolTeam.how_do_I_mail_automatically.controllers;

import com.coolTeam.how_do_I_mail_automatically.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send/{email}")
    public ResponseEntity<String> sendEmail(@PathVariable(value = "email") String email) throws IOException {
        return ResponseEntity.ok(emailService.sendEmail(email));
    }
}