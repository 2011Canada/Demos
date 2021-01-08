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

import com.revature.models.PaperOption;
import com.revature.services.PaperOptionService;

@RestController
@RequestMapping("/paper")
public class PaperOptionController {

	private PaperOptionService pos;
	
	@Autowired
	public PaperOptionController(PaperOptionService pos) {
		this.pos= pos;
	}
	
	@GetMapping
	public ResponseEntity<List<PaperOption>> getAllPaperOptions(){
		return new ResponseEntity<List<PaperOption>>(pos.findAllPaperOptions(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaperOption> findPaperById(@PathVariable int id){
		return new ResponseEntity<PaperOption>(pos.findPaperOptionById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<PaperOption> savePaperOption(@RequestBody PaperOption po){
		return new ResponseEntity<PaperOption>(pos.savePaperOption(po), HttpStatus.CREATED);
	}
	
	
}
