package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.services.ActionService;

@RestController
@RequestMapping("/action")
public class ActionController {
@Autowired
	private ActionService actionService ; 
	

@GetMapping
private List<Action> findall() {
	return actionService.findall(); 
}

}
