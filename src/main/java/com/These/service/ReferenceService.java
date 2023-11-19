package com.These.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.These.entity.Reference;
import com.These.repository.ReferenceRepository;

@Service
public class ReferenceService {

	
	@Autowired
	private ReferenceRepository rRepo;
	
	public void save(Reference r) {
		rRepo.save(r);
	}
	
	public List<Reference> getAllReference(){
		return rRepo.findAll();
	}
	
	public Reference getReferenceById(int id) {
		return rRepo.findById(id).get();
	}
	public void deleteById(int id) {
		rRepo.deleteById(id);
	}
	 
	
}
