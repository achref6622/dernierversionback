package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Gestionnaire extends Users implements Serializable {
	@JsonIgnore
	@OneToMany(mappedBy = "gestionnaire")
	private List<Client> clients;

	public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(Integer id, String nom, String email, String password, String tel, String adresse) {
		super(id, nom, email, password, tel, adresse);
		// TODO Auto-generated constructor stub
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
	

}
