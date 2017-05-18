package com.legal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.legal.dao.IDao;
import com.legal.metier.Stock;
import com.legal.service.exceptions.ArticleNotFoundException;
import com.legal.service.exceptions.NotEnoughArticleException;
import com.legal.service.exceptions.QteNegativeException;

@Service
@Transactional
public class ServiceImpl implements IService {

	@Autowired
	IDao dao;
	
	@Override
	public void sortArticleduStock(int id, int qte)  throws ArticleNotFoundException, QteNegativeException, NotEnoughArticleException{
		
		if(qte < 0){
			throw new QteNegativeException();
		}
				if(!dao.exists(id)){
			throw new ArticleNotFoundException();
		}
		if(dao.findOne(id).getQte() < qte){
			throw new NotEnoughArticleException();
		}
		dao.sortArticleduStock(id, qte);
	}

	
	@Override
	public int getQtyEnStock(int id) throws ArticleNotFoundException {
	
		if(!dao.exists(id)){
			throw new ArticleNotFoundException();
		}
		return dao.findOne(id).getQte();
	}


	@Override
	public void ajouter(Stock c) {
		dao.save(c);
	}



}
