package com.tnt.bourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Admin;
import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.entities.Users;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.model.PasswordDto;
import com.tnt.bourse.services.AdminService;
import com.tnt.bourse.services.ClientService;
import com.tnt.bourse.services.GestionnaireService;
import com.tnt.bourse.services.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private GestionnaireService gestionnaireService;
	@Autowired
	private ClientService clientService;

	@PutMapping("/profil")
	public MessageResponse changeProfile(@RequestBody Users user) {

		Users u = userService.findById(user.getId());

		if (u instanceof Client) {
			Client client = new Client(user.getId(), user.getNom(), user.getEmail(), user.getPassword(), user.getTel(),
					user.getAdresse());
			return clientService.update(client);
		} else if (u instanceof Admin) {

			Admin admin = new Admin(user.getId(), user.getNom(), user.getEmail(), user.getPassword(), user.getTel(),
					user.getAdresse());
			return adminService.update(admin);
		} else {
			Gestionnaire gest = new Gestionnaire(user.getId(), user.getNom(), user.getEmail(), user.getPassword(),
					user.getTel(), user.getAdresse());
			return gestionnaireService.update(gest);
		}

	}

	@GetMapping("/{email}")
	public Users getUserByEmail(@PathVariable String email) {

		return userService.findByEmail(email);

	}

	@PutMapping("/pwd")
	public MessageResponse changePassword(@RequestBody PasswordDto pwd) {
		return userService.changePassword(pwd);
	}

}
