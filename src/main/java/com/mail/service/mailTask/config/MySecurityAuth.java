package com.mail.service.mailTask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.mail.service.mailTask.customeUser.CustomeUserDetails;
import com.mail.service.mailTask.customeUser.UserDetailsSer;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class MySecurityAuth extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsSer custome;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//		    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		    .and()
			.authorizeRequests()
			.antMatchers("/public/**").permitAll()
			.anyRequest()
			.authenticated()
			.and().formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(custome).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder  passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}

}
