package com.mail.service.mailTask.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.mycofig.EmailService;
import com.mail.service.mailTask.repo.LoginRepo;

@Component
public class OTPUtil {


    @Autowired
    private EmailService emailService;
@Autowired
private LoginRepo repo;
     public String getOTP(int id,UserInfo user)
     {
    	 Random rnd = new Random();
    	
 		int number = rnd.nextInt(9999);
 		// this will convert any number sequence into 6 character.
 		user.setOpt(String.valueOf( id +number*100));
 		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" +user.getOpt());

	    emailService.sendPreConfiguredMail("DO NOT SHARE");
		emailService.sendMail("iftekhara226@gmail.com", "DO NOT SHARE", "you secret number is "+user.getOpt());
	
 		this.repo.save(user);

 		return String.format("%d%d", number,id);
     }
}
