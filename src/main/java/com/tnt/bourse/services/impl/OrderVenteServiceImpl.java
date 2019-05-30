package com.tnt.bourse.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.Ordre;
import com.tnt.bourse.entities.PortefeuillAction;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.entities.Vente;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.OrderVenteRepository;
import com.tnt.bourse.repositories.PortefeuilleActionRepository;
import com.tnt.bourse.services.OrderVenteService;
@Service
public class OrderVenteServiceImpl implements OrderVenteService {

	@Autowired
	private OrderVenteRepository orderVenteRepository ;
	@Autowired
	private PortefeuilleActionRepository PortefeuilleActionRepository ; 
	
	@Override
	public MessageResponse save(Vente orderVente) {

		///////gestionnaire
		PortefeuillAction portefeuilleAction = PortefeuilleActionRepository
				.findById(orderVente.getPortefeuillAction().getId()).orElse(null);

List<Ordre> p =	portefeuilleAction.getOrders() ; 
/*
for (int i =0 ; i<p.size() ; i++) {
	 if (p.get(i) instanceof Achat) {
		
if (p.get(i).getEtat().equals("executer")) {
	if (p.get(i).getQuantite() >= orderVente.getQuantite() ) {
	//save
	orderVente.setDateCreation( new Date() ) ; 
	orderVente.setEtat("Crée") ; 
	orderVenteRepository.save(orderVente) ;
	return new MessageResponse(true, "operation effectuer avec succes ") ; 
}else { 
	new MessageResponse(false, "passer quantite trouve ") ;
}
	} }
} */
 Boolean op = false ; 
int i = 0;
while ((i < p.size() )||(op = false)) {
	 if (p.get(i) instanceof Achat) {
			
if (p.get(i).getEtat().equals("executer")) {
	if (p.get(i).getQuantite() >= orderVente.getQuantite() ) {
	//save
	orderVente.setDateCreation( new Date() ) ; 
	orderVente.setEtat("Crée") ; 
	orderVenteRepository.save(orderVente) ;
	op = true ; 
	return new MessageResponse(true, "operation effectuer avec succes ") ; 
}else { 
	new MessageResponse(false, "passer quantite trouve ") ;
}
	} }
    i++;
}

	 

return new MessageResponse(false, "verifier votre portfeuille") ;
	}

	@Override
	public List<Vente> findall() {
		// TODO Auto-generated method stub
	return orderVenteRepository.findAll() ; 	}

	@Override
	public List<Vente> findmyvente(int id) {
		
List<Vente> ventes= orderVenteRepository.findAll() ; 
List<Vente> result = new ArrayList<>() ; 
for ( int i=0 ; i<ventes.size() ; i++) {
	if (ventes.get(0).getPortefeuillAction().getPortefeuille().getId() ==id ) {
	result.add(ventes.get(i)) ; 	
	}
}
return result ; 
	}		

	}


