package com.mail.service.mailTask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.service.mailTask.entity.UserInfo;
@Repository
public interface LoginRepo extends JpaRepository<UserInfo, Integer> {
	public UserInfo  findByComEail(String mail);
}
