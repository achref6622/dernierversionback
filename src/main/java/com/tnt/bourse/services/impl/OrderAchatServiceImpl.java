package com.tnt.bourse.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.entities.PortefeuillAction;
import com.tnt.bourse.entities.PortefeuillActionId;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.OrderAchatRepository;
import com.tnt.bourse.repositories.PortefeuilleActionRepository;
import com.tnt.bourse.repositories.PortefeuilleRepository;
import com.tnt.bourse.services.OrderAchatService;

@Service
public class OrderAchatServiceImpl implements OrderAchatService {

	@Autowired
	private PortefeuilleRepository PortefeuilleRepository ; 
	@Autowired
	private OrderAchatRepository orderachatrepository;
	@Autowired
	private PortefeuilleActionRepository portefeuilleActionRepository;

	@Override
	public MessageResponse save(Achat orderachat) {
		// gestionnaire 
		if (orderachat.getPortefeuillAction().getPortefeuille()
				.getNumeraire() < (orderachat.getPrix() * orderachat.getQuantite())) {
			return new MessageResponse(false, "Solde inssufisant");
		}
		orderachat.setEtat("Crée");
		orderachat.setDateCreation(new Date());

		
		System.out.println(orderachat.getPortefeuillAction().getId().getIdAction());
		System.out.println(orderachat.getPortefeuillAction().getId().getIdPortefeuille()+"************");
		PortefeuillAction portefeuilleAction = portefeuilleActionRepository
				.findById(orderachat.getPortefeuillAction().getId()).orElse(null);

		if (portefeuilleAction == null) {
			portefeuilleActionRepository.save(orderachat.getPortefeuillAction());
		}
		orderachatrepository.save(orderachat);
		return new MessageResponse(true, "Opération effectuée avec succès");
//	orderachat.getPortefeuillAction()
		/*
		 * 
		 * if ( orderachat.getClient().getPortefeuille().getNumeraire()<orderachat.
		 * getPrixVenteMax()) { return new MessageResponse(false,
		 * "verifier votre portfeuille ") ; } orderachat.setDateAchat(new Date());
		 * orderachatrepository.save(orderachat) ;
		 * orderachat.getClient().getPortefeuille().setNumeraire(orderachat.getClient().
		 * getPortefeuille().getNumeraire() - orderachat.getPrixVenteMax()); return new
		 * MessageResponse( true , " operation effectue avec succe" ) ;
		 * 
		 */

	}

	@Override
	public MessageResponse update(Achat orderachat) {
		if (orderachatrepository.findById(orderachat.getId()) == null) {
			return new MessageResponse(false, " introuvable");
		}
		orderachatrepository.save(orderachat);
		return new MessageResponse(true, " operation effectue avec succe");

	}

	@Override
	public List<Achat> findAll() {
		// TODO Auto-generated method stub
	return orderachatrepository.findAll() ; 
	}

	@Override
	public List<Achat> findmyachat(int id) {
		
List<Achat> achat= orderachatrepository.findAll() ; 
List<Achat> result = new ArrayList<>() ; 
for ( int i=0 ; i<achat.size() ; i++) {
	if (achat.get(0).getPortefeuillAction().getPortefeuille().getId() ==id ) {
	result.add(achat.get(i)) ; 	
	}
}
return result ; 
}

	}





