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
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.OrderAchatService;

@RestController
@RequestMapping("/achat")
public class OrderAchatController {
	
	@Autowired
	private OrderAchatService orderAchatService;

	@PostMapping
	public MessageResponse save(@RequestBody Achat achat) {
		return orderAchatService.save(achat);
	}
	@GetMapping
	public List< Achat> getall () { 
		return orderAchatService.findAll() ; 
	}
	
	@GetMapping("/myachat")
	public List<Achat> findmyachat(@RequestParam("id") int id) {
		return orderAchatService.findmyachat( id) ; 
	}
}
