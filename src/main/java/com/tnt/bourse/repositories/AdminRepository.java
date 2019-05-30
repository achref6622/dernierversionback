package com.tnt.bourse.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	List<Admin> findByEmail(String email);
	List<Admin > findByEmailAndId(String email,int id);


}
