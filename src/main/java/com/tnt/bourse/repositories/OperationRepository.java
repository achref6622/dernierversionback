package com.tnt.bourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Operation;

public interface OperationRepository extends JpaRepository< Operation, Integer> {

}
