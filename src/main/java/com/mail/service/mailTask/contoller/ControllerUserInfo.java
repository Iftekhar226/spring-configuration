package com.mail.service.mailTask.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.mailTask.entity.Register;
import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.service.LoginServerImp;

@RestController
@RequestMapping("/hello")
public class ControllerUserInfo {
	@Autowired
	LoginServerImp ser;
	@Autowired
	private BCryptPasswordEncoder br;

	@PostMapping("/register")
	public String register(@RequestBody Register newUser)
	{
		UserInfo user= UserInfo.builder().name(newUser.getName()).realEmail(newUser.getMailId()).build();
		ser.register(user);
		return "Success";
	}
	@PostMapping("/{em}")
	public String otp(@PathVariable("em") String email)
	{
	System.out.println(">>>>>>>>>>>>" +email);	  
		return ser.getOtp(email);
		
	}
//	@GetMapping(value = "/demo")
//	public String publicMethods() {
//		Random rnd = new Random();
//		int number = rnd.nextInt(9999);
//		UserInfo ur = new UserInfo();
//		// this will convert any number sequence into 6 character.
//		System.out.println(">>>>>>>>>>>>>>>>>>>" + ur.getId());
//		return String.format("%04d %d", number, ur.getId());
//
//	}
//
//	@GetMapping(value = "/demo/{username}")
//	public boolean demo(@PathVariable("username") String vr) {
//		UserInfo user = ser.getUserById(Integer.parseInt(vr));
//		if (user == null) {
//			return false;
//		} else {
//			return true;
//		}
//	}
}
