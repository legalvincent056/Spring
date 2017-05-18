package com.legal.dao;

import java.util.List;

import com.legal.metier.User;

public interface IDao {

	public void ajouterUser(User u);

	public List<User> listerUsers();

	public void supprimerUser(long id);

	public User trouverUser(long id);

	public List<User> listerParMC(String nom);

	public List<User> listerParNom(String nom);
}
