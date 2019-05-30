package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.model.MessageResponse;

public interface PortfeuilleService {
	
	
	public MessageResponse save(Portefeuille portfeuille);

	public MessageResponse update(Portefeuille portefeuille );

	public MessageResponse delete(int id);

	public List<Portefeuille> findAll();
	
	//public Portefeuille findbyclient ( int idclient) ; 
	
	public String generateNumProtfeuille();
	
	public Portefeuille findbyid ( int id) ; 
	
	
	
}
