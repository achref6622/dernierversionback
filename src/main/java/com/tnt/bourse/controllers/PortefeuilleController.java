package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.ClientService;
import com.tnt.bourse.services.PortfeuilleService;


@RestController
@RequestMapping("/portefeuille")
public class PortefeuilleController {

	@Autowired
	private PortfeuilleService portefeuilleService;
	
	@GetMapping
	public List<Portefeuille> findAll(){
		return portefeuilleService.findAll();
	}
	
	
	@PostMapping
	public MessageResponse save(@RequestBody Portefeuille portefeuille) {
		
	 return portefeuilleService.save(portefeuille); 
	 
	} 
	@PutMapping
	public MessageResponse update(@RequestBody Portefeuille  portefeuille) {
	
	return	portefeuilleService.update(portefeuille);
	}
	

	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable("id") int id) {
		return portefeuilleService.delete(id);
	}/*
	@GetMapping("/id")
public Portefeuille findbyclient (@RequestParam("id") int id ) {
	
	return portefeuilleService.findbyclient(id) ; 
	
}*/
	@GetMapping("findportfeuille")
 public Portefeuille findbyid (@RequestParam("id") int id) { 
	 return portefeuilleService.findbyid(id) ; 
 }
}
