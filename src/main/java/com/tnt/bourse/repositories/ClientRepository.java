package com.tnt.bourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Portefeuille;
import com.tnt.bourse.entities.Gestionnaire;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findByEmail(String email);
	List<Client> findByEmailAndId(String email,int id);
	List<Client> findByGestionnaireIsNull();
	
	//Client findById(int id);

}
