package com.tnt.bourse.services.impl;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Action;
import com.tnt.bourse.entities.CoursHistorique;
import com.tnt.bourse.repositories.ActionRepository;
import com.tnt.bourse.repositories.CourRepository;
import com.tnt.bourse.services.ActionService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {
	@Autowired
	private ActionRepository actionRepository;
	@Autowired
	private CourRepository courRepository;

	//@Scheduled(fixedDelay = 300000, initialDelay = 1000)
	@Override
	public void extraction() {
//		 NumberFormat formatter = NumberFormat.getInstance(new Locale("en", "US"));
//		 formatter.setMaximumFractionDigits(3);
//		 formatter.setMinimumFractionDigits(0);
		Document doc;
		try {
			doc = Jsoup.connect("http://www.macsa.com.tn/MACSA-NEW/marche/index.xhtml").get();

			String title = doc.title();
			Element tab = doc.getElementById("j_idt145:cotation_data");

			Elements rows = tab.getElementsByTag("tr");
			rows.forEach(row -> {

				Action action = new Action();
				CoursHistorique cours = new CoursHistorique();
				String nomAction = "";
				Elements columns = row.getElementsByTag("td");
				for (int i = 0; i < columns.size(); i++) {
					if (i == 0) {
						String a = columns.get(i).getElementsByTag("a").attr("href");
						nomAction = columns.get(i).text();

						try {

							Document doc2 = Jsoup.connect("http://www.macsa.com.tn/MACSA-NEW/" + a).get();
							
							cours.setBas(doc2.getElementById("j_idt207:j_idt242").text().replaceAll(",", "."));
							cours.setHaut(doc2.getElementById("j_idt207:j_idt238").text().replaceAll(",", "."));
							Elements rows2 = doc2.getElementById("j_idt207:limits_data").getElementsByTag("tr");

							int quantiteAchat = 0;
							int quantiteVente = 0;
							for (Element row2 : rows2) {
								Elements columns2 = row2.getElementsByTag("td");

								for (int j = 0; j < columns2.size(); j++) {
									if (j == 2) {
										quantiteAchat += Integer
												.parseInt(columns2.get(j).text().replaceAll("\\s+", ""));
									}
									if (j == 5) {
										quantiteVente += Integer
												.parseInt(columns2.get(j).text().replaceAll("\\s+", ""));
									}
								}

							}
							cours.setQteAchat(String.valueOf(quantiteAchat));
							cours.setQteVente(String.valueOf(quantiteVente));

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

//					if (i == 1) {
//
//						System.out.println(columns.get(i).text());
//					}

					if (i == 2) {
						cours.setOuverture(columns.get(i).text().replaceAll(",", "."));

					}

					if (i == 3) {
						cours.setCours(columns.get(i).text().replaceAll(",", "."));

					}

					if (i == 4) {
						cours.setVariation(columns.get(i).text().replaceAll(",", "."));

					}

					if (i == 5) {
						cours.setQuantite(columns.get(i).text());

					}

					if (i == 6) {
						cours.setVolume(columns.get(i).text().replaceAll(",", "."));

					}

				}

				Action act = actionRepository.findByNom(nomAction);
				if (act != null) {
					action = act;
				}

				action.setDateModification(new Date());
				action.setNom(nomAction);
				action = actionRepository.save(action);

				cours.setAction(action);
				cours.setDate(new Date());
				courRepository.save(cours);
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Override
	public Action findbyid(int id) {
		// TODO Auto-generated method stub
return	actionRepository.findById(id) ; 
	}

	@Override
	public List<Action> findall() {
		// TODO Auto-generated method stub
		return actionRepository.findAll() ; 
	}

}
