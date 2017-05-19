package com.legal.dao;

import java.util.List;

import com.legal.metier.Personne;

public interface IPersonneDao {

	public void savePersonne(Personne employe);

	public Personne getPersonneById(int id);
	public Personne loadPersonneByUsername(String username);

	public int getPersonnesCount();
	public List<Personne> getAllPersonnes();

}
