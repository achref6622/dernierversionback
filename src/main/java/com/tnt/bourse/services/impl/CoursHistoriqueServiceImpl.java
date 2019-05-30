package com.tnt.bourse.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.CoursHistorique;
import com.tnt.bourse.repositories.ActionRepository;
import com.tnt.bourse.repositories.CourRepository;
import com.tnt.bourse.services.CoursHistoriqueService;

@Service
public class CoursHistoriqueServiceImpl implements CoursHistoriqueService {
	@Autowired
	private CourRepository courRepository;
	@Autowired
	private ActionRepository actionRepository;

	@Override
	public List<CoursHistorique> findLastCours() {
		Stream<CoursHistorique> stream1 = courRepository.findLastCours().stream().limit(actionRepository.count());

		List<CoursHistorique> listC = stream1.collect(Collectors.toList());
		return listC;
	}

	@Override
	public List<CoursHistorique> findByAction(int idAction, Date d1, Date d2) {
		Action action = new Action();
		action.setId(idAction);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		d2 = calendar.getTime();
		return courRepository.findByActionAndDateIsBetween(action, d1, d2);

	}

}
