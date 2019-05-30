package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Ordre;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.OrderService;

@RestController
@RequestMapping ("/Order")
public class OrderController {
	@Autowired
	private OrderService orderService ; 
	@GetMapping
	public List< Ordre> getall () { 
		return orderService.findall() ;  
	}
	
	@PutMapping
	public MessageResponse update (@RequestBody Ordre ordre  ) {
		return orderService.update(ordre ) ; 
	}
	@GetMapping("/findbyid")
	public Ordre findOrdre (@RequestParam("id") int id ) {
		return orderService.findordre(id) ; 
	}

	@PutMapping("/annuler")
	public MessageResponse annuler (@RequestBody Ordre ordre  ) {
		return orderService.annuler(ordre ) ; 
	}
}
