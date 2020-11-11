//package com.m3.service;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Component;
//
//import com.m3.dao.UserDao;
//import com.m3.model.User;
//
//@Component
//public class MailService {
//	
//	@Autowired
//	private UserDao ud;
//	private JavaMailSender mailSender;
//	
//	public void sendMessage(String email) {
//		mailSender = getJavaMailSender();
//		
//		try {
//			User u = ud.findByEmail(email);
//		} catch (Exception e){
//			System.out.println("Could not find a user");
//			return;
//		}
//		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("mailmailmailadm@gmail.com");
//		message.setTo(email);
//		message.setSubject("Password Reset - Mail Mail Mail");
//		String text = "Thank you for using Mail Mail Mail! \n" + "If you did not request a password reset, you can safely ignore this message. \n" + "Please follow this link to reset your password: http://18.191.119.230:8081/Project2-1.0.0/resetPassword.app?email="+email;
//		message.setText(text);
//		mailSender.send(message);
//	}
//	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	    
//	    mailSender.setUsername(getEmail());
//	    mailSender.setPassword(getPass());
//	    
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	    
//	    return mailSender;
//	}
//	
//	public String getEmail() {
//		User u = ud.findById(15);
//		return u.getEmail();
//	}
//	
//	public String getPass() {
//		User u = ud.findById(15);
//		return u.getPassword();
//	}
//}
