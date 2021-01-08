package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.PurchaseHistory;
import com.revature.services.PurchaseHistoryService;

@RestController
@RequestMapping("/purchase-history")
public class PurchaseHistoryController {

	private PurchaseHistoryService phs;
	
	@Autowired
	public PurchaseHistoryController(PurchaseHistoryService phs) {
		this.phs= phs;
	}
	
	@GetMapping
	public ResponseEntity<List<PurchaseHistory>> getAllPurchaseHistorys(){
		return new ResponseEntity<List<PurchaseHistory>>(phs.findAllPurchaseHistorys(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PurchaseHistory> findPaperById(@PathVariable int id){
		return new ResponseEntity<PurchaseHistory>(phs.findPurchaseHistoryById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<PurchaseHistory> savePurchaseHistory(@RequestBody PurchaseHistory po){
		return new ResponseEntity<PurchaseHistory>(phs.savePurchaseHistory(po), HttpStatus.CREATED);
	}
	
	
}
