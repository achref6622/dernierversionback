package com.tnt.bourse.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.entities.Ordre;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.OrderAchatRepository;
import com.tnt.bourse.repositories.OrderRepository;
import com.tnt.bourse.repositories.PortefeuilleActionRepository;
import com.tnt.bourse.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository ; 
	
	@Autowired
	private OrderAchatRepository ordreachatrepository ; 
	
	@Autowired
	private PortefeuilleActionRepository PortefeuilleActionRepository ; 


	@Override
	public List<Ordre> findall() {
		// TODO Auto-generated method stub
	return orderRepository.findAll() ; 
	}

	@Override
	public MessageResponse update(Ordre ordre) {
	/* if (ordre instanceof Achat) {
	
		
	}
		*/
//		Achat new_name = (Achat) ordre;

		orderRepository.save(ordre) ; 
	

		return new MessageResponse(true , "achat effectue avec succe") ; 
/*	}else {
		o
		return new MessageResponse(true, "vente effectue avec succe ");
	}
 */
	}

	@Override
	public Ordre findordre(int id) {
	return orderRepository.findById(id).orElse(null) ;
	}

	@Override
	public MessageResponse annuler(Ordre ordre) {
		ordre.setEtat("Annuler");
		orderRepository.save(ordre ) ; 
return new MessageResponse(true, "annulation effectue avec succe") ; 
	}

}
