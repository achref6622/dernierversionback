package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.entities.Vente;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.OrderVenteService;

@RestController
@RequestMapping("/vente")
public class OrderVenteController {
	@Autowired
	private OrderVenteService orderVenteService ; 
	
	@PostMapping
	public MessageResponse save(@RequestBody Vente vente) {
		System.out.println("********************************");
	return orderVenteService.save(vente);	}
	
	@GetMapping
public List<Vente> findall ( ) { 
	return orderVenteService.findall() ; 
}
	
	@GetMapping("/myvente")
	public List<Vente> findmyvente(@RequestParam("id") int id) {
		return orderVenteService.findmyvente(id) ; 
	}
}
