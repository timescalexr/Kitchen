package com.mutfakapp.xmutfak.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mutfakapp.xmutfak.entity.Receipt;

@Repository
public class ReceiptDapImpl implements ReceiptDao{
	
	@Autowired
	private SessionFactory sessionFactoryX;

	@Override
	public List<Receipt> getAllReceipt() {
		
		Session sessionX = sessionFactoryX.getCurrentSession();
		CriteriaBuilder crtbuilder = sessionX.getCriteriaBuilder();
		CriteriaQuery<Receipt> crtquery = crtbuilder.createQuery(Receipt.class);
		Root<Receipt> rt = crtquery.from(Receipt.class);
		crtquery.select(rt);
		
		Query qy = sessionX.createQuery(crtquery);
		return qy.getResultList();
		
	}

	@Override
	public void saveReceipt(Receipt receipt) {
		Session sessionX = sessionFactoryX.getCurrentSession();
		sessionX.saveOrUpdate(receipt);
		
	}

	@Override
	public Receipt getReceiptById(long receiptId) {
		Session sessionX = sessionFactoryX.getCurrentSession();
		Receipt receiptX = sessionX.get(Receipt.class, receiptId);
		return receiptX;
	}

	@Override
	public void deleteReceipt(long receiptId) {
		
		Session sessionX = sessionFactoryX.getCurrentSession();
		Receipt receiptX = sessionX.byId(Receipt.class).load(receiptId);
		sessionX.delete(receiptX);
	}

}
