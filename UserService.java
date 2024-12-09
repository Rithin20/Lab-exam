package com.handloom.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.handloom.model.User;
import com.handloom.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
