package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Ordre;
import com.tnt.bourse.model.MessageResponse;;

public interface OrderService {
	public List<Ordre> findall( ) ; 
	public MessageResponse update ( Ordre ordre) ; 
public Ordre findordre ( int id) ;
public MessageResponse annuler ( Ordre ordre) ; 
}
