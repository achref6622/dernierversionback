package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Ordre  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateExecution;
	private int quantite;
	private String etat;
	private double prix;
	@ManyToOne
	private PortefeuillAction portefeuillAction;
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private List<Operation> operations;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateExecution() {
		return dateExecution;
	}
	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public PortefeuillAction getPortefeuillAction() {
		return portefeuillAction;
	}
	public void setPortefeuillAction(PortefeuillAction portefeuillAction) {
		this.portefeuillAction = portefeuillAction;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
{
	}
	
	
	
}
