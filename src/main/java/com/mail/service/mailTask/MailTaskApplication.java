package com.mail.service.mailTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.repo.LoginRepo;

@SpringBootApplication
public class MailTaskApplication{
@Autowired
private LoginRepo repo;
@Autowired
BCryptPasswordEncoder cr;
	public static void main(String[] args) {
		SpringApplication.run(MailTaskApplication.class, args);
		
	    }

	
}
