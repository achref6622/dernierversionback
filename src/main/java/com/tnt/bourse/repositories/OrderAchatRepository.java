package com.tnt.bourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Achat;

public interface OrderAchatRepository  extends JpaRepository< Achat, Integer>{

}
