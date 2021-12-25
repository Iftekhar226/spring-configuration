package com.mail.service.mailTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.mycofig.EmailService;
import com.mail.service.mailTask.repo.LoginRepo;
import com.mail.service.mailTask.util.OTPUtil;
@Service
public class LoginServerImp implements LoginServer {
   @Autowired
   private LoginRepo repo;
   @Autowired
   BCryptPasswordEncoder bCrypt;
@Autowired
 private OTPUtil util;
   @Autowired
   private EmailService emailService;
	@Override
	public UserInfo save(UserInfo us) {
		if(repo.existsById(us.getId()))
		{
		us.setPassword(bCrypt.encode(us.getPassword()));
		return repo.save(us);
		}else 
			throw new UsernameNotFoundException("no user Id found");		

	}
	
	public UserInfo register(UserInfo us) {
		return repo.save(us);
	}
	public String getOtp(String email)
	{
		UserInfo user = repo.findByRealEmail(email);
		if(user != null) {
			String[] newEmail = email.split("@",0);
			user.setWebEmail(newEmail[0]+"@mailer.com");
				String pin = util.getOTP(user.getId(),user);
				
				
				emailService.sendMail(email, "DO NOT SHARE", "your  secret otp number is :"+pin+" \n\n emailId :  "+newEmail[0]+"@mailer.com  ");
			
				return "Success";
		}
		return "fails";
	}
	@Override
	public List<UserInfo> getAllUser() {
		return repo.findAll();
	}
	@Override
	public UserInfo getUserById(int email) {
	 return getAllUser().stream().filter(user -> user.getId() == email).findAny().orElse(null);
	}
	
	public UserInfo getByUserName(String email) {
		
		return getAllUser().stream().filter(user -> user.getWebEmail().equals(email)).findAny().orElse(null);
	}

}
