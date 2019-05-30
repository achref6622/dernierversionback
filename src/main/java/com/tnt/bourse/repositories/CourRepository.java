package com.tnt.bourse.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.CoursHistorique;

public interface CourRepository extends JpaRepository<CoursHistorique, Integer> {
	@Query("select c from CoursHistorique c inner join c.action a1 where c.date = (Select  MAX (c1.date)  from Action a  inner join a.cours c1 where c1.id= c.id )  ORDER BY c.id DESC ")
	public List<CoursHistorique> findLastCours();

	public List<CoursHistorique> findByAction(Action action);

	public List<CoursHistorique> findByActionAndDateIsBetween(Action action, Date date1, Date date2);

	@Query("select   avg(c.cours) from CoursHistorique c where DAYOFWEEK(c.date) = :day and WEEK(c.date)= :week and Month(c.date)= :month and Year(c.date)= :year and c.action=:action")
	Double findDayByWeek(@Param("day") int day, @Param("week") int week, @Param("month") int month,
			@Param("year") int year, @Param("action") Action action);

	@Query("select   avg(c.cours) from CoursHistorique c where Month(c.date)= :month and Year(c.date)= :year and DAYOFMONTH(c.date) between :d1 and :d2 and c.action=:action")
	Double findWeekByMonth(@Param("month") int month, @Param("year") int year, @Param("d1") int d1,
			@Param("d2") int d2, @Param("action") Action action);
	
	@Query("select   avg(c.cours) from CoursHistorique c where Month(c.date)= :month and Year(c.date)= :year  and c.action=:action")
	Double findByMonth(@Param("month") int month, @Param("year") int year,
			 @Param("action") Action action);
}
