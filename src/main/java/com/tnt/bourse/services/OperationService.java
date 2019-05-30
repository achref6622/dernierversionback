package com.tnt.bourse.services;

import com.tnt.bourse.entities.Operation;
import com.tnt.bourse.model.MessageResponse;

public interface OperationService {
	public MessageResponse exucuter ( Operation operation) ; 
	public MessageResponse annuler ( Operation operation) ; 

}
