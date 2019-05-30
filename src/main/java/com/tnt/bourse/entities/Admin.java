package com.tnt.bourse.entities;

import javax.persistence.Entity;


@Entity
public class Admin extends Users{

	public Admin(Integer id, String nom, String email, String password, String tel, String adresse) {
		super(id, nom, email, password, tel, adresse);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
