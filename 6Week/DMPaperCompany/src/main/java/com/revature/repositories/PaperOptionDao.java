package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PaperOption;

public interface PaperOptionDao extends JpaRepository<PaperOption, Integer>{

}
