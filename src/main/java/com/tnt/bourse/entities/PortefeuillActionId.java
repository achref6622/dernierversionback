package com.tnt.bourse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class PortefeuillActionId  implements Serializable{
	@Column(name="id_protefeuille")
	private Integer idPortefeuille;
	@Column(name="id_action")
	private Integer idAction;
	
	
	public Integer getIdPortefeuille() {
		return idPortefeuille;
	}
	public void setIdPortefeuille(Integer idPortefeuille) {
		this.idPortefeuille = idPortefeuille;
	}
	public Integer getIdAction() {
		return idAction;
	}
	public void setIdAction(Integer idAction) {
		this.idAction = idAction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAction == null) ? 0 : idAction.hashCode());
		result = prime * result + ((idPortefeuille == null) ? 0 : idPortefeuille.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortefeuillActionId other = (PortefeuillActionId) obj;
		if (idAction == null) {
			if (other.idAction != null)
				return false;
		} else if (!idAction.equals(other.idAction))
			return false;
		if (idPortefeuille == null) {
			if (other.idPortefeuille != null)
				return false;
		} else if (!idPortefeuille.equals(other.idPortefeuille))
			return false;
		return true;
	}
	

}
