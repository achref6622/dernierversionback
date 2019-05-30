package com.tnt.bourse.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.ClientRepository;
import com.tnt.bourse.repositories.PortefeuilleRepository;
import com.tnt.bourse.services.PortfeuilleService;
import com.tnt.bourse.utils.RandomNumber;

@Service
@Transactional
public class PotefeuilleServiceImpl implements PortfeuilleService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PortefeuilleRepository portefeuilleRepository;
	@Autowired
	private RandomNumber randomNumber;

	@Override
	public MessageResponse save(Portefeuille portfeuille) {
		portfeuille.setNumPortefeuille( generateNumProtfeuille());

		List<Portefeuille> liste = portefeuilleRepository.findByNumPortefeuille(portfeuille.getNumPortefeuille());
		if (!liste.isEmpty()) {
			return new MessageResponse(false, "portefeuille existant");
		}
//portfeuille.getPortefeuillActions().size() 
		portfeuille.setDateCreation(new Date());
		portfeuille.setDateModification(null);
		
		portfeuille.setNumeraire(0);
		portefeuilleRepository.save(portfeuille);
		return new MessageResponse(true, "operation effectué avec succe");

	}

	@Override
	public MessageResponse update(Portefeuille portefeuille ) {

	
		List<Portefeuille> liste = portefeuilleRepository.findByNumPortefeuilleAndId(portefeuille.getNumPortefeuille(),
				portefeuille.getId());
		if (liste.isEmpty()) {
			liste = portefeuilleRepository.findByNumPortefeuille(portefeuille.getNumPortefeuille());
			if (!liste.isEmpty()) {
				return new MessageResponse(false, "portefeuille existant");
			}
		}

Portefeuille pf = portefeuilleRepository.findById(portefeuille.getId()).orElse(null) ; 
System.out.println(  pf.getClient()) ;
pf.setNumeraire(portefeuille.getNumeraire());
	/*do{
		 i++ ; 
		 System.out.println(listcl.get(i).getPortefeuille());
		 
		  }while((listcl.get(i).getPortefeuille().equals( portefeuille)));
	/*if (listcl.get(i).getPortefeuille().equals( portefeuille)){
		System.out.println(listcl.get(i).getPortefeuille());
	}*/
	
		pf.setDateModification(new Date());
		
		portefeuilleRepository.save(pf);
		return new MessageResponse(true, "operation effectué avec succe");
	}

	@Override
	public MessageResponse delete(int id) {
		// delete
		// TODO Auto-generated method stu
				Portefeuille pf = portefeuilleRepository.findById(id);
				if (pf == null) {
					return new MessageResponse(false, " portfeuille n'exist pas");
				}

				if  (pf.getPortefeuillActions().isEmpty()== false  )      {
					return new MessageResponse(false , "portfeuille a un action ") ; 
					
				}
				if  (pf.getNumeraire()>0)    {
					return new MessageResponse(false , "portfeuille  ") ; 
					
				}
				
			
			/*	if (pf.getClient() != null) {

					return new MessageResponse(false, " potfeuille possede un client ");
				}*/
				
			//	if (portefeuilleRepository.)
				pf.setClient(null);
			
		
			portefeuilleRepository.delete(pf);
				return new MessageResponse(true, "operation effectue avec succe ");

			}

	@Override
	public List<Portefeuille> findAll() {
		return portefeuilleRepository.findAll();
	}

	@Override
	public String generateNumProtfeuille() {
		// TODO Auto-generated method stub
		return randomNumber.generateMyNumber();
	}
/*
	@Override
	public Portefeuille findbyclient(int idclient) {
		Client clt = new  Client ( ) ; 
	clt.setId(idclient);
	return portefeuilleRepository.findByClient(clt) ; 
	}*/

	@Override
	public Portefeuille findbyid(int id) {
	return portefeuilleRepository.findById(id) ;
	}

}