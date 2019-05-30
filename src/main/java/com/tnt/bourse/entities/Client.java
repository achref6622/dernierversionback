package com.tnt.bourse.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends Users {
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	private Portefeuille portefeuille;
	@ManyToOne
	private Gestionnaire gestionnaire;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Client(Integer id, String nom, String email, String password, String tel, String adresse) {
		super(id, nom, email, password, tel, adresse);
		// TODO Auto-generated constructor stub
	}

	public Portefeuille getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(Portefeuille portefeuille) {
		this.portefeuille = portefeuille;
	}

}
