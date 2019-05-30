package com.tnt.bourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Admin;
import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.AdminService;
import com.tnt.bourse.services.ClientService;
import com.tnt.bourse.services.GestionnaireService;

@RestController
@RequestMapping("/register")
public class RegisterController {
		
	
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private GestionnaireService gestionnaireService ; 
	
	@Autowired
	private AdminService adminService ; 
	
	@PostMapping
	public MessageResponse save(@RequestBody Client client) {
		return clientService.save(client);
	}
	@PostMapping ("/gestion")
	public MessageResponse savegestionnaire (@RequestBody Gestionnaire gestionnaire) {
		return gestionnaireService.save(gestionnaire);
	}
	@PostMapping("/admin")
	public MessageResponse save(@RequestBody Admin admin) {
		return adminService.save(admin);}
		
	@PutMapping("/addprf")
		public MessageResponse ajouterportfeuille(@RequestBody Client client) {
			System.out.println("***********************************");
			return clientService.ajoutportfeuille(client);
		}


	
}
