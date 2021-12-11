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
   LoginRepo repo;
   @Autowired
   BCryptPasswordEncoder bCrypt;
@Autowired
 private OTPUtil util;
   
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
//			  this.repo.delete(user);
				String pin =util.getOTP(repo.findByRealEmail(email).getId(),user);
			
			  
				return "success";
		}
		return "fails";
	}
	@Override
	public List<UserInfo> getAllUser() {
		return repo.findAll();
	}
	@Override
	public UserInfo getUserById(int email) {
		//emailService.sendMail("iftekhara226@gmail.com", "Happy Coding", "Email sent with demo application");
        
      //  emailService.sendPreConfiguredMail("Happy Coding");
	 return getAllUser().stream().filter(user -> user.getId() == email).findAny().orElse(null);
		//emailService.sendMail("iftekhara226@gmail.com", "Happy Coding", "Email sent with demo application");
        
	}
	
	public UserInfo getByUserName(String email) {
		
		return getAllUser().stream().filter(user -> user.getWebEmail().equals(email)).findAny().orElse(null);
	}

}
