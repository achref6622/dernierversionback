package com.tnt.bourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Action;

public interface ActionRepository extends JpaRepository<Action,Integer > {

	public Action findByNom(String nom);
	public Action findById ( int id ) ; 
}
