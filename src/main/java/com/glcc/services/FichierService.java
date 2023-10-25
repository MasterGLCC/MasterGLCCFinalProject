package com.glcc.services;


import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.glcc.models.Fichier;

@Service
public interface FichierService {
	List<Fichier> getAllFiles();
    void saveAllFilesList(List<Fichier> fileList);
  
}
