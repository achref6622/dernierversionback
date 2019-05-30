package com.tnt.bourse.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Admin;
import com.tnt.bourse.entities.Users;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.AdminRepository;
import com.tnt.bourse.repositories.UserRepository;
import com.tnt.bourse.services.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public MessageResponse save(Admin admin) {

		Users list = userRepository.findByEmail(admin.getEmail());
		if (list != null) {
			return new MessageResponse(false, "Email existant");
		}

		String pwd = bCryptPasswordEncoder.encode(admin.getPassword());
		admin.setPassword(pwd);

		adminRepository.save(admin);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Admin admin) {
		Users list = userRepository.findByEmailAndId(admin.getEmail(), admin.getId());
		if (list == null) {
			list = userRepository.findByEmail(admin.getEmail());
			if (list != null) {
				return new MessageResponse(false, "Email existant");
			}
		}

		adminRepository.save(admin);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

}
