package com.tnt.bourse.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tnt.bourse.entities.Users;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.model.PasswordDto;

public interface UsersService extends UserDetailsService {
	Users findById(int id);

	Users findByEmail(String email);

	public MessageResponse changePassword(PasswordDto passwordDto);

}
