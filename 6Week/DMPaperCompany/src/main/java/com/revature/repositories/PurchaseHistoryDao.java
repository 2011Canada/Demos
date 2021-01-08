package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PurchaseHistory;

public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistory, Integer>{

}
