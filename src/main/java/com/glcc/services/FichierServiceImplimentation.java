package com.glcc.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcc.models.Fichier;
import com.glcc.repository.IFichierRepostory;

@Service
public class FichierServiceImplimentation implements FichierService{
	 @Autowired 
	   IFichierRepostory fichierRepository;
	   
	    public List<Fichier> getAllFiles() {
	        // fetch all the files form database
	        return fichierRepository.findAll();
	    }
	    public void saveAllFilesList(List<Fichier> fileList) {
	        // Save all the files into database
	        for (Fichier fileModal : fileList)
	        	fichierRepository.save(fileModal);
	    }
	    
	    public Fichier getFileById(Long id) {
	        // fetch all the files form database
	        return fichierRepository.findFileById(id);
	    }
}
