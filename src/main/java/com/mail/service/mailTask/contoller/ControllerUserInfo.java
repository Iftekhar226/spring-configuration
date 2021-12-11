package com.mail.service.mailTask.contoller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.service.LoginServer;

@RestController
@RequestMapping("/hello")
public class ControllerUserInfo {
	@Autowired
	LoginServer ser;
	@Autowired
	private BCryptPasswordEncoder br;

	@GetMapping(value="/demo")
	public String publicMethods()
	{
		 Random rnd = new Random();
		    int number = rnd.nextInt(9999);
 UserInfo ur= new UserInfo();
		    // this will convert any number sequence into 6 character.
 System.out.println(">>>>>>>>>>>>>>>>>>>"+ur.getId());
		    return String.format("%04d %d", number , ur.getId());
		
	}
	@GetMapping(value="/demo/{username}")
	public boolean demo(@PathVariable("username") String vr)
	{
		//System.out.println("hiiiiiiiiii");
		
		
		UserInfo user = ser.getUserById(Integer.parseInt(vr));
		if(user == null)
		{
			return false;
		}
		else {
		return true;
		}
}
	}
	
	
	

