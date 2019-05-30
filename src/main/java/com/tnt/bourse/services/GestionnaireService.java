package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.model.MessageResponse;

public interface GestionnaireService {
	public MessageResponse save(Gestionnaire gestionnaire);
	public MessageResponse update(Gestionnaire gestionnaire);
	public MessageResponse delete(int id);
	public List<Gestionnaire> findAll();
	public Gestionnaire addClient (Gestionnaire  gestionnaire, Client client) ; 
	public List<Client> mesclient (int id ) ; 
	

}
