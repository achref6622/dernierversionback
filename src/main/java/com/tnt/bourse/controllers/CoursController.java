package com.tnt.bourse.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.CoursHistorique;
import com.tnt.bourse.services.CoursHistoriqueService;

@RestController
@RequestMapping("/cours")
public class CoursController {
	@Autowired
	private CoursHistoriqueService coursHistoriqueService;
	@GetMapping
	public List<CoursHistorique> findLastCours() {
		return coursHistoriqueService.findLastCours();
	}

	@GetMapping("/historique")
	public List<CoursHistorique> findByAction(@RequestParam("id") int id, 
			@RequestParam("date1")  @DateTimeFormat(pattern="dd/MM/yyyy")Date d1 ,
			 @DateTimeFormat(pattern="dd/MM/yyyy") @RequestParam("date2") Date d2) {
		System.out.println(d1);
		System.out.println(d2);
		return coursHistoriqueService.findByAction(id, d1, d2);														
	}
}
