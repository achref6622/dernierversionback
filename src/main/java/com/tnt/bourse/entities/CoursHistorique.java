package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cours_historique")
public class CoursHistorique implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String ouverture;
	private String haut;
	private String bas;
	private String variation;
	private String quantite;
	private String volume;
	private String qteAchat;
	private String qteVente;
	private String cours;
	
	@ManyToOne
	private Action action;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getOuverture() {
		return ouverture;
	}


	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}


	public String getHaut() {
		return haut;
	}


	public void setHaut(String haut) {
		this.haut = haut;
	}


	public String getBas() {
		return bas;
	}


	public void setBas(String bas) {
		this.bas = bas;
	}


	public String getVariation() {
		return variation;
	}


	public void setVariation(String variation) {
		this.variation = variation;
	}


	public String getQuantite() {
		return quantite;
	}


	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}


	public String getVolume() {
		return volume;
	}


	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getQteAchat() {
		return qteAchat;
	}


	public void setQteAchat(String qteAchat) {
		this.qteAchat = qteAchat;
	}


	public String getQteVente() {
		return qteVente;
	}


	public void setQteVente(String qteVente) {
		this.qteVente = qteVente;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}


	public String getCours() {
		return cours;
	}


	public void setCours(String cours) {
		this.cours = cours;
	}



	
	
	

}
