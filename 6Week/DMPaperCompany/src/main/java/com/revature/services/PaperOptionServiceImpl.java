package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PaperOption;
import com.revature.repositories.PaperOptionDao;

@Service
public class PaperOptionServiceImpl implements PaperOptionService {

	private PaperOptionDao pod;
	
	@Autowired
	public PaperOptionServiceImpl(PaperOptionDao pod) {
		this.pod = pod;
	}
	
	
	@Override
	public List<PaperOption> findAllPaperOptions() {
		// TODO Auto-generated method stub
		return pod.findAll();
	}

	@Override
	public PaperOption findPaperOptionById(int id) {
		// TODO Auto-generated method stub
		return pod.getOne(id);
	}

	@Override
	public PaperOption savePaperOption(PaperOption C) {
		// TODO Auto-generated method stub
		return pod.save(C);
	}

}
