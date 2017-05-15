package com.legal.TPInjectionSpectacle;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1- Chargement du container et Création des Beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spectacle.xml");

		// 2- Récupération d'un Bean
		Performeur olivier = (Performeur) appContext.getBean("olivier");
		
		Performeur  caroline = (Performeur) appContext.getBean("caroline");
		
		Performeur jeanMarc = (Performeur) appContext.getBean("jeanMarc");
				
		Performeur julien =  (Performeur) appContext.getBean("julien");
		
		Performeur alain = (Performeur) appContext.getBean("alain");
		
		Performeur louis =(Performeur) appContext.getBean("louis");
		
		Performeur michel = (Performeur) appContext.getBean("michel");
		
		Performeur maurice = (Performeur) appContext.getBean("maurice");
		
		Performeur martin = (Performeur) appContext.getBean("martin");
		
		Performeur monMusicien = (Performeur) appContext.getBean("monMusicien");
		
		Instrument maGuitare = (Instrument) appContext.getBean("maGuitare");
		
		
		// 3- Traitement
		System.out.println("-------------OLIVIER---------------------");
		System.out.println(olivier);
		olivier.performe();
		System.out.println("-------------CAROLINE---------------------");
		System.out.println(caroline);
		caroline.performe();
		System.out.println("--------------JEAN-MARC----------------------");
		System.out.println(jeanMarc);
		jeanMarc.performe();
		System.out.println("-------------JULIEN-----------------------");
		System.out.println(julien);
		julien.performe();
		System.out.println("---------------ALAIN---------------------");
		System.out.println(alain);
		alain.performe();
		System.out.println("---------------LOUIS---------------------");
		louis.performe();
		System.out.println("---------------MICHEL---------------------");
		michel.performe();
		System.out.println("---------------MAURICE--------------------");
		maurice.performe();
		System.out.println("---------------MARTIN--------------------");
		martin.performe();
		System.out.println("---------------MON-MUSICIEN--------------------");
		monMusicien.performe();
		System.out.println("---------------MON PIANO--------------------");
		maGuitare.jouer();
		System.out.println(maGuitare);
		
		// 4- Détruire le context
		appContext.close();

	}

}
