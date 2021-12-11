package service;

import java.util.List;

import com.mail.service.mailTask.entity.UserInfo;

public interface LoginServer {
	public UserInfo save(UserInfo us);
	public List<UserInfo> getAllUser();
	public UserInfo getUserById(String email);
}
