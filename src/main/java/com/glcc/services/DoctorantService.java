package com.glcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcc.models.Doctorant;
import com.glcc.models.Sujet;
import com.glcc.repository.IDocRepository;
import com.glcc.repository.IEtatRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class DoctorantService {
	@Autowired
	IDocRepository repo;
	public Doctorant viewById(long id) {
        return repo.findById(id).get();
    }
}
