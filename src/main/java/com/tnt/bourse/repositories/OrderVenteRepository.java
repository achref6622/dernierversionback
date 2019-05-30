package com.tnt.bourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Vente;

public interface OrderVenteRepository extends JpaRepository<Vente, Integer> {

}
