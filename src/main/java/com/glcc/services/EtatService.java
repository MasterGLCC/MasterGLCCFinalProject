package com.glcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcc.models.Etat_avancement;
import com.glcc.models.Doctorant;
import com.glcc.repository.IEtatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EtatService {
	@Autowired
	IEtatRepository repo;
	
	public List<Object[]> getAllEtatByProf(Long id) {
		
		return repo.findEtatByProfLog(id);
		//return repo.findDoctorantEtatByProfLog(id);
	}
	
public List<Object[]> getSujetByEtat(Long id) {
		
		return repo.findDoctorantSujById(id);
	}
	
	public Etat_avancement getDetailsById(Long id) {
		return repo.findById(id).get();
	}
	 public  List<Etat_avancement[]> getEtatBySujet(Long id) {
		Long idS=repo.findIdSujet(id);
		 return repo.findEtatBySujet(idS);
	 }
	 public  List<Etat_avancement> getEtatByIdTh(Long id) {
			Long idS=repo.findIdSujet(id);
			 return repo.findByIdTh(idS);
		 }
		 
	 public Etat_avancement getEtatById(Long id) {
		 return repo.findEtatById(id);
	 }
	 
	 public void updateNote(int note, Long id) {
		    Optional<Etat_avancement> optionalEtat = repo.findById(id);

		    if (optionalEtat.isPresent()) {
		        Etat_avancement etat = optionalEtat.get();
		        etat.setNote(note);
		        repo.save(etat);
		        repo.flush();
		    } 
		}
	 
	 public Etat_avancement modifierNote(Etat_avancement etat) {
		 return repo.save(etat);
	 }
}
