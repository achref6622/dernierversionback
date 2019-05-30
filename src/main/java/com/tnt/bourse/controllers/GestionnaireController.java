package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.GestionnaireService;


@RestController
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@Autowired
	private GestionnaireService gestionnaireService;
	
	@GetMapping
	public List<Gestionnaire> findAll(){
		return gestionnaireService.findAll();
	}
	
	
	@PostMapping
	public MessageResponse save(@RequestBody Gestionnaire gestionnaire) {
		//System.out.println("**********************");
		
	 return gestionnaireService.save(gestionnaire); 
	 
	} 
	@PutMapping
	public MessageResponse update(@RequestBody Gestionnaire  gestionnaire) {
	
	return	gestionnaireService.update(gestionnaire);
	}
	

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id") int id) {
		return gestionnaireService.delete(id);
	}
	@GetMapping("/mesclient")
	public List<Client> clientdegestionnaire (@RequestParam("id") int  id) { 
		return gestionnaireService.mesclient(id) ; 
	}
}
