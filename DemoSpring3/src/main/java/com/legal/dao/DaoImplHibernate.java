package com.legal.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.legal.metier.User;

@Transactional
@Repository
public class DaoImplHibernate implements IDao {
	
	@Autowired //Création des sessions avec Hibernate (avec JPA ->EntityManagerFactory)
	private SessionFactory sessionfactory;
	
	
	private Session getSession(){ //Création de la requête (avec JPA->EntityManager)
		return sessionfactory.getCurrentSession();
	}
		
	
	@Override
	public void ajouterUser(User u) {
	getSession().save(u);
		
		System.out.println("Ajouter A PARTIR D'HIBERNATE");
	}

	@Override
	public List<User> listerUsers() {
		String req = "from User";
		Query query = getSession().createQuery(req);
		return query.list();
	}

	@Override
	public void supprimerUser(long id) {
		getSession().delete(getSession().get(User.class, id));

	}

	@Override
	public User trouverUser(long id) {
		return (User) getSession().get(User.class, id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		String req = "from User as u where u.nom like :nom";
		Query query = getSession().createQuery(req);
		query.setParameter("nom", "%"+nom+"%");
		return query.list();
	}

	@Override
	public List<User> listerParNom(String nom) {
		String req = "from User as u where u.nom = :nom";
		Query query = getSession().createQuery(req);
		query.setParameter("nom", nom);
		return query.list();
	}

}
