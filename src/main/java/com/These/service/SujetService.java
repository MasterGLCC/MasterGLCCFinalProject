package com.These.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.These.entity.Sujet;
import com.These.repository.SujetRepositry;




@Service
public class SujetService {
	@Autowired
	private SujetRepositry sRepo;
	
	public void saveSujet(Sujet b) {
		sRepo.save(b);
	}
	
	public List<Sujet> getAllSujet(){
		return sRepo.findAll();
	}
	
	public Sujet getSujetById(int id) {
		return sRepo.findById(id).get();
	}
	public void deleteById(int id) {
		sRepo.deleteById(id);
	}
	
}
