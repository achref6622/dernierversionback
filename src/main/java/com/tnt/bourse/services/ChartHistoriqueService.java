package com.tnt.bourse.services;

import java.util.List;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.model.ChartModel;

public interface ChartHistoriqueService {

	public List<ChartModel> chartByDay(Action action);

	public List<ChartModel> chartByWeek(Action action);

	public List<ChartModel> chartByMonth(Action action);

	public List<ChartModel> chartBySemester(Action action);

}
