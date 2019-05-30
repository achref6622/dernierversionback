package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Admin;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.services.AdminService;

@RestController
@RequestMapping("/admin")
//@PreAuthorize("hasRole('ROLE_Admin')")
public class AdminController {
	@Autowired
	private AdminService adminService;

	
	
	
	@PostMapping
	public MessageResponse save(@RequestBody Admin admin) {
		return adminService.save(admin);

	}

	@PutMapping
	public MessageResponse update(@RequestBody Admin admin) {

		return adminService.update(admin);
	}

}
