package com.legal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.legal.dao.IDao;
import com.legal.metier.User;
@Service
public class ServiceImpl implements IService {

	@Autowired
	//@Qualifier("daoImplHibernate")
	@Qualifier("daoImplJPA")
	private IDao dao;
	
	
	@Override
	public void ajouterUser(User u) {
		
		dao.ajouterUser(u);
	}

	@Override
	public List<User> listerUsers() {
		// TODO Auto-generated method stub
		return dao.listerUsers();
	}

	@Override
	public void supprimerUser(long id) {
		dao.supprimerUser(id);

	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		return dao.trouverUser(id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		// TODO Auto-generated method stub
		return dao.listerParMC(nom);
	}

	@Override
	public List<User> listerParNom(String nom) {
		// TODO Auto-generated method stub
		return dao.listerParNom(nom);
	}

}
