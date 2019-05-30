package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "portefeuille_action")
public class PortefeuillAction implements Serializable {
	@EmbeddedId
	private PortefeuillActionId id;
	@Column(name = "nbr_action")
	private int nbrAction;
	@ManyToOne
	@JoinColumn(name = "id_protefeuille", insertable = false, updatable = false)
	private Portefeuille portefeuille;
	@ManyToOne
	@JoinColumn(name = "id_action", insertable = false, updatable = false)
	private Action action;
	@JsonIgnore
	@OneToMany(mappedBy = "portefeuillAction")
	private List<Ordre> orders;

	
	public PortefeuillActionId getId() {
		return id;
	}

	public void setId(PortefeuillActionId id) {
		this.id = id;
	}

	public int getNbrAction() {
		return nbrAction;
	}

	public void setNbrAction(int nbrAction) {
		this.nbrAction = nbrAction;
	}

	public Portefeuille getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(Portefeuille portefeuille) {
		this.portefeuille = portefeuille;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public List<Ordre> getOrders() {
		return orders;
	}

	public void setOrders(List<Ordre> orders) {
		this.orders = orders;
	}



	
	

}
