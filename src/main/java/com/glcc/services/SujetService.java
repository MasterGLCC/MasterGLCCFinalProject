package com.glcc.services;

import java.awt.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcc.models.Sujet;
import com.glcc.repository.ISujetRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class SujetService {
	@Autowired
	ISujetRepository repo;
	public Sujet getsujetbyid(Long id) {
		return repo.findsujetbyiddoc(id);
	}
	
	
}
