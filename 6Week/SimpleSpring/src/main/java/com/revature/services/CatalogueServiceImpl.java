package com.revature.services;

import com.revature.repositories.CatalogueDao;
import com.revature.repositories.MediaDao;

public class CatalogueServiceImpl implements CatalogueService {

	private CatalogueDao cd;
	
	private MediaDao md;
	
	public String getCatalogueById(int catalogueId) {
		// TODO Auto-generated method stub
		return cd.getByID(catalogueId);
	}

	public String getMediaFromCatalogue(int catalogueId) {
		//pretend to get all movies
		return md.getByID(catalogueId);
	}

}
