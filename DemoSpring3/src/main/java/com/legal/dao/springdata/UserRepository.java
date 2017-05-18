package com.legal.dao.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.legal.metier.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByNom(String nom);
	
	@Query("SELECT u FROM User u WHERE u.nom like %?1%")
	public List<User> findByMc(String nom);

}
