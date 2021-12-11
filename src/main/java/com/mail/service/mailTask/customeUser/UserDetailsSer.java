package com.mail.service.mailTask.customeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mail.service.mailTask.entity.UserInfo;
import com.mail.service.mailTask.repo.LoginRepo;
@Service
public class UserDetailsSer implements UserDetailsService {

	@Autowired
	LoginRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = this.repo.findByComEail(username);
	if(user == null)
		throw new UsernameNotFoundException("no user found");
	return new CustomeUserDetails(user); 
	}

}
