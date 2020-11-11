package com.m3.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.m3.dao.UserDao;
import com.m3.model.User;
/**
 * 
 * <h1>MailService</h1>
 * <p>The mail service is used to email information from the front end to a user.</p>
 * <p>This class is not managed by Spring.</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
public class MailService {
	
	/**
	 * This field is a UserDao, which is a component used to communicate directly with the repository.
	 */
	private UserDao ud = new UserDao();
	
	/**
	 * This field is a JavaMailSender. It contains information about the mailing protocol, its properties, and the user sending the message.
	 */
	private JavaMailSender mailSender;
	
	/**
	 * <p>The sendMessage method sends a custom email to a user based on the provided email.</p>
	 * 
	 * @param String email
	 */
	public void sendMessage(String email) {
		mailSender = getJavaMailSender();
		User u;
		try {
			u = ud.findByEmail(email);
		} catch (Exception e){
			System.out.println("Could not find a user");
			return;
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("mailmailmailadm@gmail.com");
		message.setTo(email);
		message.setSubject("Password Reset - Mail Mail Mail");
		String text = "Thank you for using Mail Mail Mail! \n" + "If you did not request a password reset, you can safely ignore this message. \n" + "Please follow this link to reset your password: http://www.mailmailmail.com.s3-website-us-west-1.amazonaws.com/reset/pass/"+email+"\n Use this code when prompted: "+u.getPassword();
		message.setText(text);
		mailSender.send(message);
	}
	
	/**
	 * <p>The getJavaMailSender method sets the host, port, user details, and protocol information for the JavaMailSender.</p>
	 * 
	 * @return JavaMailSender mailSender
	 */
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername(getEmail());
	    mailSender.setPassword(getPass());
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	/**
	 * <p>The getEmail method gets the email address of the user to send from.</p>
	 * 
	 * @return String UserDao.getEmail();
	 */
	public String getEmail() {
		User u = ud.findById(15);
		return u.getEmail();
	}
	
	/**
	 * <p>The getPass method gets the password of the user to send from.</p>
	 * 
	 * @return String UserDao.getPassword();
	 */
	public String getPass() {
		User u = ud.findById(15);
		return u.getPassword();
	}
}
