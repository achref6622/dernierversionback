package com.tnt.bourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.model.ChartModel;
import com.tnt.bourse.repositories.ActionRepository;
import com.tnt.bourse.services.ActionService;
import com.tnt.bourse.services.ChartHistoriqueService;

@RestController
@RequestMapping("/chart")
public class ChartHistoriqueController {

	@Autowired
	private ChartHistoriqueService charthistoriqueService;

	@GetMapping("/byDay/{id}")
	public List<ChartModel> chartByDay(@PathVariable("id") int id) {
		Action action = new Action();
		action.setId(id);
		
		System.out.println("********************");
		return charthistoriqueService.chartByDay(action);
	}

	@GetMapping("/byWeek/{id}")
	public List<ChartModel> chartByWeek(@PathVariable("id") int id) {
		Action action = new Action();
		action.setId(id);
		return charthistoriqueService.chartByWeek(action);

	}

	@GetMapping("/byMonth/{id}")
	public List<ChartModel> chartByMonth(@PathVariable("id") int id) {
		Action action = new Action();
		action.setId(id);
		return charthistoriqueService.chartByMonth(action);

	}

	@GetMapping("/bySemestre/{id}")
	public List<ChartModel> chartBySemestre(@PathVariable("id") int id) {
		Action action = new Action();
		action.setId(id);
		return charthistoriqueService.chartBySemester(action);

	}


}
