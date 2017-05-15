package com.legal.DemoSpring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1- Chargement du container et Création des Beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2- Récupération d'un Bean
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societe");
		
		//3- Traitement
		System.out.println(societe);
		
		//4- Détruire le context
		appContext.close();
		
	}

}
