package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.Operation;

public interface ActionService {
	
	public void extraction () ; 
	public Action findbyid ( int id) ; 
	public List<Action> findall ( ) ; 
	
	

	
	

}
