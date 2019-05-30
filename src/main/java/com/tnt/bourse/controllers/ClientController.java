package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.ClientRepository;
import com.tnt.bourse.services.ClientService;
@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository ClientRepository ; 
	
	//@PreAuthorize("hasRole('ROLE_Admin')")
	
	@PutMapping("/addprf")
	public MessageResponse ajouterportfeuille(@RequestBody Client client) {
	//	System.out.println("***********************************");
		return clientService.ajoutportfeuille(client);
	}
	@GetMapping
	public List<Client> findAll() {
		return clientService.findAll();
	}


	@PostMapping
	public MessageResponse affect(@RequestBody List<Client> clients) {
		return clientService.affecter(clients);
	}
	
	@PutMapping("/delet")
	public MessageResponse delet(@RequestBody List<Client> clients) {
		return clientService.deleteclientdegestionnaire(clients);
	}
	
	@PutMapping
	public MessageResponse update(@RequestBody Client client) {
		return clientService.update(client);
	}

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id") int id) {
		return clientService.delete(id);
		
	}
	
	//@GetMapping("/portfeuille")
	@GetMapping("/pr")
	public List<Client> findById () {
		List< Client> a = null  ; 
	  a.add(ClientRepository.getOne(1)) ; 
	
	  return a ; 
	}
	
	@GetMapping ("/sansgest")
public List<Client> findgest ( ) { 
	return clientService.findClientNotAffected(); 
}
	@GetMapping("/getclient")
public Client getuserclient (@RequestParam("id") int id) { 
		
		return clientService.userclient(id) ; 
	
}
	@PutMapping("/deletgestionnair")
	public void deletgestionnaire (@RequestBody Client client) {
	
		clientService.deletgestionnaire(client);
	}
	
}
