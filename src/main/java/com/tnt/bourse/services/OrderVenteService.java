package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.Vente;
import com.tnt.bourse.model.MessageResponse;

public interface OrderVenteService {
	public MessageResponse save(Vente orderVente);
	public List< Vente> findall () ;
	public List<Vente> findmyvente ( int id) ; 


}
