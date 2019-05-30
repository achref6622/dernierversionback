package com.tnt.bourse.services;


import com.tnt.bourse.entities.Admin;
import com.tnt.bourse.model.MessageResponse;

public interface AdminService {
	public MessageResponse save(Admin admin );
	public MessageResponse update(Admin admin );

}
