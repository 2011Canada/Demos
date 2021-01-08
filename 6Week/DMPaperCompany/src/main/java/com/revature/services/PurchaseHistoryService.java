package com.revature.services;

import java.util.List;

import com.revature.models.PurchaseHistory;

public interface PurchaseHistoryService {
	
	public List<PurchaseHistory> findAllPurchaseHistorys();
	
	public PurchaseHistory findPurchaseHistoryById(int id);
	
	public PurchaseHistory savePurchaseHistory(PurchaseHistory C);
}
