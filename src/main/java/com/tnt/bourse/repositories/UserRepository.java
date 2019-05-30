package com.tnt.bourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
 Users findByEmail(String email);

Users findByEmailAndId(String email, Integer id);

}
