package com.legal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.legal.metier.User;

@Transactional
@Repository
public class DaoImplJPA implements IDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("Ajouter A PARTIR DE JPA");
		entityManager.persist(u);
	}

	@Override
	public List<User> listerUsers() {
		return entityManager.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public void supprimerUser(long id) {
//		entityManager.remove(entityManager.contains(id) ? id:entityManager.merge(id));
		entityManager.remove(trouverUser(id));
	}

	@Override
	public User trouverUser(long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		String req = "SELECT u FROM User u where u.nom like :nom";
		Query query = entityManager.createQuery(req);
		query.setParameter("nom", "%"+nom+"%");
		return query.getResultList();
	}

	@Override
	public List<User> listerParNom(String nom) {
		String req = "SELECT u FROM User u where u.nom like :nom";
		Query query = entityManager.createQuery(req);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

}
