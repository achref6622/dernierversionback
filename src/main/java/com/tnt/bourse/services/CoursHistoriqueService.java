package com.tnt.bourse.services;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.tnt.bourse.entities.CoursHistorique;

public interface CoursHistoriqueService {
	
	public List<CoursHistorique> findLastCours();
	public List<CoursHistorique> findByAction(int idAction,Date d1, Date d2);
}
