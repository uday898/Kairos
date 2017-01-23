package com.watches.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.watches.model.Customer;
@Service
public class EmailService {
	public static final String REPLY_TO_ADDRESS="donotreply@kairos.com";
	public static final String FROM_ADDRESS="kairos.team@gmail.com";
	@Autowired
	public JavaMailSender javaMailSender;
public void send(Customer customer, String subject,String body) throws MessagingException
{
	
	 MimeMessage mail=javaMailSender.createMimeMessage();
	 MimeMessageHelper helper=new MimeMessageHelper(mail,true);
	 helper.setTo(customer.getCustomerEmail());
	 helper.setReplyTo(REPLY_TO_ADDRESS);
	 helper.setFrom(FROM_ADDRESS);
	 helper.setSubject(subject);
	helper.setText(body);
	javaMailSender.send(mail);
		
	 
}	

}

