package com.tnt.bourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;

public interface GestionnaireRepository extends JpaRepository< Gestionnaire, Integer> {
	Gestionnaire findByEmail(String email);
	List<Gestionnaire > findByEmailAndId(String email,int id);
	public Gestionnaire findById(int id) ; 
	
}
