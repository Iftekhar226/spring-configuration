package com.mail.service.mailTask.customeUser;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mail.service.mailTask.entity.UserInfo;

public class CustomeUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3943224476507054654L;
	 private UserInfo info;
	 
	 public CustomeUserDetails(UserInfo info)
	 {
		 this.info = info;
	 }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
     HashSet<SimpleGrantedAuthority> set = new HashSet<>();
	set.add(new SimpleGrantedAuthority(this.info.getRole()));	
     return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.info.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.info.getComEail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
