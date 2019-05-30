package com.tnt.bourse.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Action implements Serializable {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "date_modification")
	@Temporal(TemporalType.DATE)
	private Date dateModification ; 
	
	private String nom ; 

	@JsonIgnore
	@OneToMany(mappedBy = "action")
	private List<CoursHistorique> cours;
	@JsonIgnore
	@OneToMany(mappedBy = "action")
	private List<PortefeuillAction> portefeuillActions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public List<CoursHistorique> getCours() {
		return cours;
	}

	public void setCours(List<CoursHistorique> cours) {
		this.cours = cours;
	}

	public List<PortefeuillAction> getPortefeuillActions() {
		return portefeuillActions;
	}

	public void setPortefeuillActions(List<PortefeuillAction> portefeuillActions) {
		this.portefeuillActions = portefeuillActions;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

}
