package com.tnt.bourse.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.CoursHistorique;
import com.tnt.bourse.model.ChartModel;
import com.tnt.bourse.repositories.CourRepository;
import com.tnt.bourse.services.ChartHistoriqueService;

@Service
public class ChartHistoriqueServiceImpl implements ChartHistoriqueService {
	@Autowired
	private CourRepository courRepository;

	@Override
	public List<ChartModel> chartByDay(Action action) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date d1 = calendar.getTime();

		calendar.add(Calendar.DAY_OF_MONTH, 1);
	
		Date d2 = calendar.getTime();

	
		List<CoursHistorique> list = courRepository.findByActionAndDateIsBetween(action, d1, d2);
		List<ChartModel> listChart = new ArrayList<>();
		list.forEach(cours -> {
			ChartModel chartModel = new ChartModel();
		
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			String xAxis = format.format(cours.getDate());
			chartModel.setxAxis(xAxis);

			chartModel.setyAxis(cours.getCours());
			listChart.add(chartModel);
		});

		System.out.println(listChart.size());
		return listChart;
	}

	@Override
	public List<ChartModel> chartByWeek(Action action) {
		List<ChartModel> listChart = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();

		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Double result = courRepository.findDayByWeek(2, week - 1, month + 1, year, action);

		ChartModel chartModel = new ChartModel();
		chartModel.setxAxis("Lundi");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findDayByWeek(3, week - 1, month + 1, year, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Mardi");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findDayByWeek(4, week - 1, month + 1, year, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Mercredi");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findDayByWeek(5, week - 1, month + 1, year, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Jeudi");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findDayByWeek(6, week - 1, month + 1, year, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Vendredi");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		return listChart;
	}

	@Override
	public List<ChartModel> chartByMonth(Action action) {
		List<ChartModel> listChart = new ArrayList<>();

		listChart = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();

		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Double result = courRepository.findWeekByMonth(month + 1, year, 1, 8, action);

		ChartModel chartModel = new ChartModel();
		chartModel.setxAxis("Semaine 1");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);
		result = courRepository.findWeekByMonth(month + 1, year, 9, 15, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Semaine 2");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findWeekByMonth(month + 1, year, 16, 23, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Semaine 3");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);

		result = courRepository.findWeekByMonth(month + 1, year, 24, 31, action);

		chartModel = new ChartModel();
		chartModel.setxAxis("Semaine 4");
		if (result != null)
			chartModel.setyAxis(String.valueOf(result));
		else
			chartModel.setyAxis("0");
		listChart.add(chartModel);
		return listChart;
	}

	@Override
	public List<ChartModel> chartBySemester(Action action) {
		List<ChartModel> listChart = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();

		// int month = calendar.get(Calendar.MONTH) + 1;

	
		if(calendar.get(Calendar.MONTH) ==Calendar.JANUARY) {

			Double result = courRepository.findByMonth(Calendar.AUGUST, calendar.get(Calendar.YEAR - 1), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.SEPTEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.OCTOBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.NOVEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.DECEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}

		else if(calendar.get(Calendar.MONTH) ==Calendar.FEBRUARY) {

		Double	result = courRepository.findByMonth(Calendar.SEPTEMBER, calendar.get(Calendar.YEAR - 1), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.OCTOBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.NOVEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.DECEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}
		else if(calendar.get(Calendar.MONTH) ==Calendar.MARCH) {

			Double result = courRepository.findByMonth(Calendar.OCTOBER, calendar.get(Calendar.YEAR - 1), action);

		ChartModel	chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.NOVEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.DECEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}
		else if(calendar.get(Calendar.MONTH) ==Calendar.APRIL) {
			

			Double result = courRepository.findByMonth(Calendar.NOVEMBER, calendar.get(Calendar.YEAR - 1), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.DECEMBER, calendar.get(Calendar.YEAR - 1), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}

		else if(calendar.get(Calendar.MONTH) ==Calendar.MAY) {
System.out.println("////////////////////////"+Calendar.DECEMBER);
		Double	result = courRepository.findByMonth(Calendar.DECEMBER, calendar.get(Calendar.YEAR - 1), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}

		else if(calendar.get(Calendar.MONTH) ==Calendar.JUNE) {

		Double	result = courRepository.findByMonth(Calendar.JANUARY+1, calendar.get(Calendar.YEAR), action);

		ChartModel	chartModel = new ChartModel();
			chartModel.setxAxis("Janvier");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);
		}
		else if(calendar.get(Calendar.MONTH) ==Calendar.JULY) {

		Double	result = courRepository.findByMonth(Calendar.FEBRUARY+1, calendar.get(Calendar.YEAR), action);

		ChartModel	chartModel = new ChartModel();
			chartModel.setxAxis("Février");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);
		}
		else if(calendar.get(Calendar.MONTH) ==Calendar.AUGUST) {

		Double	result = courRepository.findByMonth(Calendar.MARCH+1, calendar.get(Calendar.YEAR), action);

		ChartModel	chartModel = new ChartModel();
			chartModel.setxAxis("Mars");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.AUGUST+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}

			else if(calendar.get(Calendar.MONTH) ==Calendar.SEPTEMBER) {

			Double result = courRepository.findByMonth(Calendar.APRIL+1, calendar.get(Calendar.YEAR), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Avril");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.AUGUST+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.SEPTEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

		}

		else if(calendar.get(Calendar.MONTH) ==Calendar.OCTOBER) {

			Double result = courRepository.findByMonth(Calendar.MAY+1, calendar.get(Calendar.YEAR), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Mai");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.AUGUST+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.SEPTEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.OCTOBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);
		}
			

			else if(calendar.get(Calendar.MONTH) ==Calendar.NOVEMBER) {

		Double	result = courRepository.findByMonth(Calendar.JUNE+1, calendar.get(Calendar.YEAR), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Juin");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.AUGUST+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.SEPTEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.OCTOBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.NOVEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);
			}
			else if(calendar.get(Calendar.MONTH) ==Calendar.DECEMBER) {

			Double result = courRepository.findByMonth(Calendar.JULY+1, calendar.get(Calendar.YEAR), action);

			ChartModel chartModel = new ChartModel();
			chartModel.setxAxis("Juillet");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.AUGUST+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Aout");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.SEPTEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Septembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.OCTOBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("October");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.NOVEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Nouvembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			result = courRepository.findByMonth(Calendar.DECEMBER+1, calendar.get(Calendar.YEAR), action);

			chartModel = new ChartModel();
			chartModel.setxAxis("Décembre");
			if (result != null)
				chartModel.setyAxis(String.valueOf(result));
			else
				chartModel.setyAxis("0");
			listChart.add(chartModel);

			}
	
		

		return listChart;
	}

}
