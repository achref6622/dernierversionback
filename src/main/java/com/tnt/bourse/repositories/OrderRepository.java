package com.tnt.bourse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.tnt.bourse.entities.Ordre;;


public interface OrderRepository extends JpaRepository<Ordre, Integer> {

}
