/**
 * 
 */
package com.legal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.legal.metier.Personne;

/**
 * @author OBJIS : www.objis.com
 *
 */

@Repository("employeDAO")
public class PersonneJdbcDaoSupport implements IPersonneDao 
{
	
	@PersistenceContext
	private EntityManager em;
	

	public Personne getPersonneById(int id) {
		return em.find(Personne.class, id);
	}


	public int getPersonnesCount() {
		return em.createQuery("SELECT COUNT p FROM Personne p").getFirstResult();
	}

	
	public void savePersonne(Personne Personne) {
		em.persist(Personne);
	}

	
	@SuppressWarnings("unchecked")
	public List<Personne> getAllPersonnes() {
		return em.createQuery("SELECT p FROM Personne p").getResultList();
	}


	
	public Personne loadPersonneByUsername(String login) {
		String req = "SELECT p FROM Personne p where p.login like :login";
		Query query = em.createQuery(req);
		query.setParameter("login", login);
		return (Personne) query.getResultList();
	}

}