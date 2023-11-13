package com.coolTeam.how_do_I_mail_automatically.services;

import com.coolTeam.how_do_I_mail_automatically.configurations.SendgridConfiguration;
import com.coolTeam.how_do_I_mail_automatically.utils.MailPropUtil;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    MailPropUtil mailPropUtil = new MailPropUtil();

    @Value("${app.sendgrid.templateId}")
    private String templateId;

    private final SendGrid sendGrid;

    public EmailServiceImpl(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    @Override
    public String sendEmail(String email) throws IOException {
        Mail mail = prepareMail(email);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sendGrid.api(request);

        return "who let the dogs out";
    }

    public Mail prepareMail(String email) {
        Mail mail = new Mail(); // this is the literal mail

        Email from = new Email(); // this is the sender
        from.setEmail("pop_gabi00@yahoo.com");
        mail.setFrom(from);

        Email to = new Email(); // this is the receiver
        to.setEmail(email);

        Personalization personalization = new Personalization();
        personalization.addTo(to);

        mail.addPersonalization(personalization);

        mail.setTemplateId(templateId);
        Content content = new Content("caine", "doi");
        mail.addContent(content);
        return mail;
    }
}