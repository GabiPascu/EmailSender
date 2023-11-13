package com.coolTeam.how_do_I_mail_automatically.configurations;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendgridConfiguration {

    @Value("${app.sendgrid.key}")
    private String key;

    @Bean
    public SendGrid getSendGrid() {
        return new SendGrid(key);
    }
}