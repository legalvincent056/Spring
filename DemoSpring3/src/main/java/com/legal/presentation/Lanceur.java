package com.legal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.legal.metier.User;
import com.legal.service.IService;
import com.legal.service.ServiceImpl;

public class Lanceur {

	public static void main(String[] args) {
		// 1- Chargement du container et Création des Beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2- Récupération d'un Bean
		
		IService service = (IService) appContext.getBean("serviceImpl");
		User user = (User) appContext.getBean("user");
		user.setNom("Nom1");
		user.setPrenom("Prenom1");
		
		User user2 = (User) appContext.getBean("user");
		user2.setNom("Nom2");
		user2.setPrenom("Prenom2");
		
		User user3 = (User) appContext.getBean("user");
		user3.setNom("Nom3");
		user3.setPrenom("Prenom3");
		
		User user4 = (User) appContext.getBean("user");
		user4.setNom("Toto");
		user4.setPrenom("Roro");
		
		User user5 = (User) appContext.getBean("user");
		user5.setNom("Titi2");
		user5.setPrenom("LENOM5");
		
		System.out.println("bean user="+user.getNom());
		System.out.println("bean user2="+user2.getNom()); //Comme on a défini le Scope dans User comme Prototype, le nom de user et user2 ne sont plus identique. On ne fait plus appel au même Bean
		
		
		// 3- Utilisation des Beans
		
		System.out.println("----------------AJOUT-------------------------------");
		service.ajouterUser(user);
		service.ajouterUser(user2);
		service.ajouterUser(user3);
		service.ajouterUser(user4);
		service.ajouterUser(user5);
		
		System.out.println("-------------------SUPPRIMER------------------------");
		//service.supprimerUser(3);
		
		System.out.println("TROUVER " + service.trouverUser(4));
		
		System.out.println("------------------------LISTER USERS-----------------------");
		List<User> lister = service.listerUsers();
		for(User u:lister){
			System.out.println(u);
		}
		System.out.println("------------------------LISTER PAR NOM-----------------------");
		
		List<User> lister2 = service.listerParNom("Nom2");
		for(User u:lister2){
			System.out.println(u);
		}
		System.out.println("------------------------LISTER PAR MC-----------------------");
		
		List<User> lister3 = service.listerParMC("2");
		for(User u:lister3){
			System.out.println(u);
		}
		
		
		// 4- Détruire le context
				appContext.close();

		
		
		

	}

}
