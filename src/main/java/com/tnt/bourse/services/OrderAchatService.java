package com.tnt.bourse.services;

import java.util.List;


import com.tnt.bourse.entities.Achat;
import com.tnt.bourse.model.MessageResponse;

public interface OrderAchatService {
	public MessageResponse save(Achat achat);
	public MessageResponse update( Achat achat);
	public List<Achat> findAll();
	public List<Achat> findmyachat ( int id) ; 
}
