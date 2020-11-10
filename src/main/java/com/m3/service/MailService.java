package com.m3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.m3.dao.UserDao;
import com.m3.model.User;

@Component
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserDao ud;
	
	public void sendMessage(String email) {
		try {
			User u = ud.findByEmail(email);
		} catch (Exception e){
			System.out.println("Could not find a user");
			return;
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@mailmailmail.com");
		message.setTo(email);
		message.setSubject("Password Reset - Mail Mail Mail");
		String text = "Thank you for using Mail Mail Mail! \n" + "If you did not request a password reset, you can safely ignore this message. \n" + "Please follow this link to reset your password: http://localhost:8080/Project2/resetPassword?email="+email;
		message.setText(text);
		mailSender.send(message);
	}
	
}
