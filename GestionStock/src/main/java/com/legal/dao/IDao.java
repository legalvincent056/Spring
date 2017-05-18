package com.legal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.legal.metier.Stock;

public interface IDao extends JpaRepository<Stock, Integer> {
	@Modifying
	@Query("UPDATE Stock s set s.qte=s.qte-?2 WHERE s.id=?1")
	void sortArticleduStock(int id, int qte);
	

	
	
}