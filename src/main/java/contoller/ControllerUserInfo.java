package contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.mailTask.entity.UserInfo;

import service.LoginServer;

@RestController
public class ControllerUserInfo {
	@Autowired
	LoginServer ser;
	@PostMapping(value="/save")
	public UserInfo save(@RequestBody UserInfo us)
	{
		return ser.save(us);
		
	}

	@GetMapping(value="/public")
	public String publicMethods()
	{
		System.out.println("hiiiiiiiiii");
		return "workHIIIIIIIIIIIIIIIIIIIIIIIIII";
	}
	
	@GetMapping(value="/{userName}")
	public UserInfo save(@PathVariable("userName") String email)
	{
		
		return ser.getUserById(email);
	}
}
