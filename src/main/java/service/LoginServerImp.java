package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.repo.LoginRepo;
@Service
public class LoginServerImp implements LoginServer {
   @Autowired
   LoginRepo repo;
   @Autowired
   BCryptPasswordEncoder bCrypt;
	@Override
	public UserInfo save(UserInfo us) {
		if(repo.existsById(us.getId()))
		{
		us.setPassword(bCrypt.encode(us.getPassword()));
		return repo.save(us);
		}else 
			throw new UsernameNotFoundException("no user Id found");		

	}
	@Override
	public List<UserInfo> getAllUser() {
		return repo.findAll();
	}
	@Override
	public UserInfo getUserById(String email) {
		
		return getAllUser().stream().filter(user -> user.getComEail().equals(email)).findAny().orElse(null);
	}

}
