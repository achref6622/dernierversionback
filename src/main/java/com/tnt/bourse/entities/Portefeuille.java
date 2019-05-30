package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Portefeuille implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "num_portefeuille")
	private String numPortefeuille;

	@Column(name = "date_creation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Column(name = "date_modification")
	@Temporal(TemporalType.DATE)
	private Date dateModification;

	
	@Column(name = "numeraire")
	private float numeraire;
	
	
	@Column(name = "valorisation")
	private float valorisation;
	
	@JsonIgnore
	@OneToOne
	private Client client;
	
	@JsonIgnore
	@OneToMany(mappedBy = "portefeuille")
	private List<PortefeuillAction> portefeuillActions;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumPortefeuille() {
		return numPortefeuille;
	}

	public void setNumPortefeuille(String numPortefeuille) {
		this.numPortefeuille = numPortefeuille;
	}

	/*public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}*/

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<PortefeuillAction> getPortefeuillActions() {
		return portefeuillActions;
	}

	public void setPortefeuillActions(List<PortefeuillAction> portefeuillActions) {
		this.portefeuillActions = portefeuillActions;
	}

	public float getNumeraire() {
		return numeraire;
	}

	public void setNumeraire(float numeraire) {
		this.numeraire = numeraire;
	}

	public float getValorisation() {
		return valorisation;
	}

	public void setValorisation(float valorisation) {
		this.valorisation = valorisation;
	}

	@Override
	public String toString() {
		return "Portefeuille [id=" + id + ", numPortefeuille=" + numPortefeuille + ", dateCreation=" + dateCreation
				+ ", dateModification=" + dateModification + ", numeraire=" + numeraire + ", valorisation="
				+ valorisation + ", client=" + client + "]";
	}



	
	

}
