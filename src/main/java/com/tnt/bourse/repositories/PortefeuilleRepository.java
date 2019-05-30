package com.tnt.bourse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Portefeuille;

public interface PortefeuilleRepository extends JpaRepository<Portefeuille, Integer> {

	public Portefeuille findByClient(Client clt);
	

	public List<Portefeuille> findByNumPortefeuille (String NumPortefeuille ) ; 
	public List<Portefeuille> findByNumPortefeuilleAndId (String numPortefeuille  , int id) ; 
	public Portefeuille findById ( int id) ; 
  


	
}
