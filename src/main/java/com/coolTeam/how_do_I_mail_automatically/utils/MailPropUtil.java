package com.coolTeam.how_do_I_mail_automatically.utils;

import org.springframework.beans.factory.annotation.Value;

public class MailPropUtil {

    @Value("${app.sendgrid.templateId}")
    private String templateId;

    @Value("${myEmail}")
    private String senderEmail;

    public String getTemplateId() {
        return templateId;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}