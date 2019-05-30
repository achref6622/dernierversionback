package com.tnt.bourse.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

public class JsoupUtil {

	
	
//	public static void main(String[] args) {
//		
//		Document doc;
//		try {
//			doc = Jsoup.connect("http://www.macsa.com.tn/MACSA-NEW/marche/index.xhtml").get();
//
//			System.out.println(doc.getElementById("j_idt145:cotation").text());
//
//			String title = doc.title();
//			Element tab = doc.getElementById("j_idt145:cotation_data");
//
//			Elements rows = tab.getElementsByTag("tr");
//			rows.forEach(row -> {
//				Elements columns = row.getElementsByTag("td");
//				for (int i = 0; i < columns.size(); i++) {
//					if (i == 0) {
//						String a = columns.get(i).getElementsByTag("a").attr("href");
//						System.out.println(a);
//
//						try {
//							System.out.println("achat ********** vente");
//							Document doc2 = Jsoup.connect("http://www.macsa.com.tn/MACSA-NEW/" + a).get();
//
//							Elements rows2 = doc2.getElementById("j_idt207:limits_data").getElementsByTag("tr");
//
//							
//							int quantiteAchat = 0;
//							int quantiteVente = 0;
//							for (Element row2 : rows2) {
//								Elements columns2 = row2.getElementsByTag("td");
//
//								for (int j = 0; j < columns2.size(); j++) {
//									if (j == 2) {
//										quantiteAchat += Integer
//												.parseInt(columns2.get(j).text().replaceAll("\\s+", ""));
//									}
//									if (j == 5) {
//										quantiteVente += Integer
//												.parseInt(columns2.get(j).text().replaceAll("\\s+", ""));
//									}
//								}
//
//							}
//
//							System.out.println("achat=" + quantiteAchat);
//							System.out.println("vente=" + quantiteVente);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 1) {
//
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 2) {
//
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 3) {
//
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 4) {
//
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 5) {
//
//						System.out.println(columns.get(i).text());
//					}
//
//					if (i == 6) {
//
//						System.out.println(columns.get(i).text());
//					}
//
////					if (i == 7) {
////
////						System.out.println(columns.get(i).text());
////					}
//				}
//			});
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//	}

}
