package com.legal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.legal.dao.IDao;
import com.legal.dao.springdata.UserRepository;
import com.legal.metier.User;
@Transactional
@Service
public class ServiceImpl implements IService {

	@Autowired
	//@Qualifier("daoImplHibernate")
	//@Qualifier("daoImplJPA")
	//private IDao dao;
	
	UserRepository userRepository;
	
	@Override
	public void ajouterUser(User u) {
		
		//dao.ajouterUser(u);
		userRepository.save(u);
		
	}

	@Override
	public List<User> listerUsers() {
		
		//return dao.listerUsers();
		return userRepository.findAll();
	}

	@Override
	public void supprimerUser(long id) {
	//	dao.supprimerUser(id);
		userRepository.delete(id);

	}

	@Override
	public User trouverUser(long id) {
		
	//	return dao.trouverUser(id);
		return userRepository.findOne(id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		
	//	return dao.listerParMC(nom);
		return (List<User>) userRepository.findByMc(nom);
		
	}

	@Override
	public List<User> listerParNom(String nom) {
		
		//return dao.listerParNom(nom);
		return (List<User>) userRepository.findByNom(nom);
	}

}
