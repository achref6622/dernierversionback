package com.tnt.bourse.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.entities.Users;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.ClientRepository;
import com.tnt.bourse.repositories.GestionnaireRepository;
import com.tnt.bourse.repositories.PortefeuilleRepository;
import com.tnt.bourse.repositories.UserRepository;
import com.tnt.bourse.services.ClientService;
import com.tnt.bourse.utils.RandomNumber;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PortefeuilleRepository portefeuilleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GestionnaireRepository GestionnaireRepository ; 

	@Autowired
	private RandomNumber randomNumber;

	@Transactional
	@Override
	public MessageResponse save(Client client) {

		Users list = userRepository.findByEmailAndId(client.getEmail(), client.getId());
		if (list == null) {
			list = userRepository.findByEmail(client.getEmail());
			if (list != null) {
				return new MessageResponse(false, "Email existant");
			}
		}

		String pwd = bCryptPasswordEncoder.encode(client.getPassword());
		client.setPassword(pwd);
		
		
		Portefeuille pf = new Portefeuille();
		pf.setNumPortefeuille(generateNumProtfeuille());
		pf.setDateCreation(new Date());
		pf.setDateModification(null);

		pf.setNumeraire(0);
		pf.setClient(client);
		portefeuilleRepository.save(pf);
		clientRepository.save(client);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Transactional
	@Override
	public MessageResponse update(Client client) {

		List<Client> list = clientRepository.findByEmailAndId(client.getEmail(), client.getId());
		if (list.isEmpty()) {
			list = clientRepository.findByEmail(client.getEmail());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Email existant");
			}
		}

		clientRepository.save(client);

		return new MessageResponse(true, "Opération effectuée avec succès");

	}

	@Transactional
	@Override
	public MessageResponse delete(int id) {

		Client clt = clientRepository.findById(id).orElse(null);

		// System.out.println(clt.toString());
		if (clt == null) {

			return new MessageResponse(false, "Client n'exist pas");
		}

		Portefeuille portefeuille = portefeuilleRepository.findByClient(clt);

		if (portefeuille != null) {
			return new MessageResponse(false, clt.getNom()+ " posède un portefeuille");
		}

		clientRepository.deleteById(id);

		return new MessageResponse(true, clt.getNom() +"est effacer");
	}

	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public String generateNumProtfeuille() {
		// TODO Auto-generated method stub
		return randomNumber.generateMyNumber();
	}

	@Override
	public Client findById(int id) {
		
	
	
	  return clientRepository.findById(id).orElse(null) ;
	
	
	}

	@Override
	public List<Client> findClientNotAffected() {
		// TODO Auto-generated method stub
		return clientRepository.findByGestionnaireIsNull();
	}

	@Override
	public MessageResponse affecter(List<Client> clients) {
		
		clients.forEach(client -> {
			client.getPortefeuille().setClient(client);
			clientRepository.save(client);
		});
		
	

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public Client userclient(int id) {
		  return clientRepository.findById(id).orElse(null) ;
	}

	@Override
	public void deletgestionnaire(Client client) {
		
		
		//client.setGestionnaire(null);
		clientRepository.save(client) ;
	
		
	}

	@Override
	public MessageResponse deleteclientdegestionnaire(List<Client> clients) {
		clients.forEach(client -> {
			Portefeuille pf = portefeuilleRepository.findById(client.getPortefeuille().getId()).orElse(null) ; 
		
			 client.setPortefeuille(pf);
			client.setGestionnaire(null);
			clientRepository.save(client) ;
		});
		

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse ajoutportfeuille(Client client) {
		
		if (client.getPortefeuille() == null ) {

		Portefeuille pf = new Portefeuille();
		pf.setNumPortefeuille(generateNumProtfeuille());
		pf.setDateCreation(new Date());
		pf.setDateModification(null);
		pf.setNumeraire(0);
		//client.setPortefeuille(pf);	
		pf.setClient(client);
		portefeuilleRepository.save(pf);

		clientRepository.save(client);

		return new MessageResponse(true, "le portfeuille est ajouter a " + client.getNom());
		
	}else {
		return new MessageResponse(false, "erreur d'ajout");

	}
	} 
	
	 
}
