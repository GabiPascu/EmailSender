package com.coolTeam.how_do_I_mail_automatically.services;

import java.io.IOException;

public interface EmailService {

    String sendEmail(String email) throws IOException;
}
