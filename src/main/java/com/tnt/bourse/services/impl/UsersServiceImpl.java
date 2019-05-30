package com.tnt.bourse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Users;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.model.PasswordDto;
import com.tnt.bourse.repositories.UserRepository;
import com.tnt.bourse.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userRepository.findByEmail(username);

		return user;
	}

	@Override
	public Users findById(int id) {

		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public MessageResponse changePassword(PasswordDto passwordDto) {
		Users user = userRepository.findById(passwordDto.getId()).orElse(null);
		if (user == null) {
			return new MessageResponse(false, "Utilisateur n'existe pas");
		}

		boolean valid = bCryptPasswordEncoder.matches(passwordDto.getOldPassword(), user.getPassword());
		if (!valid) {
			return new MessageResponse(false, "Ancien Mot de passe invalid");
		}
		String pwd = bCryptPasswordEncoder.encode(passwordDto.getNewPassword());

		user.setPassword(pwd);
		userRepository.save(user);

		return new MessageResponse(true, "Mot de passe modifié avec succès");
	}

}
