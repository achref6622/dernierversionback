package com.tnt.bourse;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.tnt.bourse.controllers.ChartHistoriqueController;
import com.tnt.bourse.repositories.ActionRepository;
import com.tnt.bourse.repositories.CourRepository;
import com.tnt.bourse.repositories.PortefeuilleRepository;
import com.tnt.bourse.services.ActionService;
import com.tnt.bourse.services.ChartHistoriqueService;
import com.tnt.bourse.services.ClientService;
import com.tnt.bourse.services.impl.ChartHistoriqueServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
@EnableScheduling
public class BourseEnligneApplication implements CommandLineRunner {
	@Autowired
	private CourRepository courRepository;
	@Autowired
	private PortefeuilleRepository portefeuilleRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	ActionRepository actionRepository;
	@Autowired
	private ChartHistoriqueService charthistoriqueService;

	public static void main(String[] args) {
		SpringApplication.run(BourseEnligneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// System.out.println( clientService.findbyid(4));
		// TODO Auto-generated method stub
		/*
		 * 
		 * 
		 * 
		 * 
		 * Portefeuille p = portefeuilleRepository.findByClient(1) ;
		 * System.out.println(p.toString());
		 */
//	List<CoursHistorique> list =	courRepository.findLastCours();
		// Stream<CoursHistorique> stream1 = list.stream().limit(82);

		// stream1.close();

//	List<CoursHistorique>listC = stream1.collect(Collectors.toList());

//	listC.forEach(c-> {
//		System.out.println(c.getId());
//	});
		/*
		 * Calendar calendar = Calendar.getInstance(); int week =
		 * calendar.get(Calendar.WEEK_OF_MONTH); int month =
		 * calendar.get(Calendar.MONTH); int year = calendar.get(Calendar.YEAR);
		 * System.out.println(week);
		 * 
		 * 
		 * Double d = courRepository.findDayByWeek(1, week-1, month+1, year);
		 * if(d!=null) { System.out.println(d);
		 */

	//	charthistoriqueService.chartByWeek(actionRepository.findById(4)).forEach(c-> System.out.println(c.getyAxis()));

	}

}
