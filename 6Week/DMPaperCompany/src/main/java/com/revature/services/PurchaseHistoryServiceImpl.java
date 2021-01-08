package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PurchaseHistory;
import com.revature.models.PurchaseHistoryLine;
import com.revature.repositories.PurchaseHistoryDao;
import com.revature.repositories.PurchaseHistoryLineDao;

@Service
public class PurchaseHistoryServiceImpl  implements PurchaseHistoryService{

	private PurchaseHistoryDao phd;
	
	private PurchaseHistoryLineDao phld;
	
	@Autowired
	public PurchaseHistoryServiceImpl(PurchaseHistoryDao phd, PurchaseHistoryLineDao phld) {
		this.phd = phd;
		this.phld = phld;
	}
	
	
	@Override
	public List<PurchaseHistory> findAllPurchaseHistorys() {
		// TODO Auto-generated method stub
		return phd.findAll();
	}

	@Override
	public PurchaseHistory findPurchaseHistoryById(int id) {
		// TODO Auto-generated method stub
		return phd.getOne(id);
	}

	@Override
	@Transactional//this entire method is no a single transaction
	public PurchaseHistory savePurchaseHistory(PurchaseHistory C) {
		PurchaseHistory updated = phd.save(C);
		for(PurchaseHistoryLine phl : updated.getTotalPurchase()) {
			phl.setHistory(updated);
			phld.save(phl);
		}
		return updated;
	}

}
