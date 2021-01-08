package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PurchaseHistoryLine;

public interface PurchaseHistoryLineDao extends JpaRepository<PurchaseHistoryLine, Integer>{

}
