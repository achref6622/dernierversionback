package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity

public class Vente extends Ordre implements Serializable {
	
	private boolean partiel;

	public boolean isPartiel() {
		return partiel;
	}

	public void setPartiel(boolean partiel) {
		this.partiel = partiel;
	}







	
	
	
}
