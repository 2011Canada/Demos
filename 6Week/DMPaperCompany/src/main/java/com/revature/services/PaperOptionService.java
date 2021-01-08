package com.revature.services;

import java.util.List;

import com.revature.models.PaperOption;


public interface PaperOptionService {

	
	public List<PaperOption> findAllPaperOptions();
	
	public PaperOption findPaperOptionById(int id);
	
	public PaperOption savePaperOption(PaperOption C);
}
