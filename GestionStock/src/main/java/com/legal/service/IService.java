package com.legal.service;

import com.legal.metier.Stock;
import com.legal.service.exceptions.ArticleNotFoundException;
import com.legal.service.exceptions.NotEnoughArticleException;
import com.legal.service.exceptions.QteNegativeException;

public interface IService {
	
	public void sortArticleduStock(int id, int qte) throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException;
	
	public int getQtyEnStock(int id) throws ArticleNotFoundException;
	
	public void ajouter(Stock c);
	
}
