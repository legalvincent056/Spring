package com.legal.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.legal.metier.Stock;
import com.legal.service.IService;
import com.legal.service.exceptions.ArticleNotFoundException;
import com.legal.service.exceptions.NotEnoughArticleException;
import com.legal.service.exceptions.QteNegativeException;


public class Lanceur {

	public static void main(String[] args) throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException {
		
		// 1- Chargement du container et Création des Beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// 2- Récupération d'un Bean
		
		IService service = (IService) appContext.getBean("serviceImpl");
		Stock s =(Stock) appContext.getBean("stock");
		Stock s2 =(Stock) appContext.getBean("stock");
		Stock s3 =(Stock) appContext.getBean("stock");
		Stock s4 =(Stock) appContext.getBean("stock");
		
		
		// 3- Utilisation des Beans
//		s.setNom("ordianteur");
//		s.setQte(40);
//		service.ajouter(s);
//		
//		s2.setNom("clavier");
//		s2.setQte(30);
//		service.ajouter(s2);
//		
//		s3.setNom("ecran");
//		s3.setQte(20);
//		service.ajouter(s3);
//		
//		s4.setNom("souris");
//		s4.setQte(10);
//		service.ajouter(s4);
		
		
		service.sortArticleduStock(1, 10);
		
		
		
		// 4- Détruire le context
		appContext.close();
	}

}
