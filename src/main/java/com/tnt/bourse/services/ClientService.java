package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.model.MessageResponse;

public interface ClientService {

	public MessageResponse save(Client client);
	public MessageResponse update(Client client);
	public MessageResponse delete(int id);
	public List<Client> findAll();
	String generateNumProtfeuille();
	public Client findById ( int id ) ; 
	public List<Client> findClientNotAffected();
	public MessageResponse affecter(List<Client> clients);
	public Client userclient ( int id ) ; 
	public void deletgestionnaire (Client client) ; 
	public MessageResponse deleteclientdegestionnaire(List<Client> clients);
	public MessageResponse ajoutportfeuille ( Client client) ; 
}
