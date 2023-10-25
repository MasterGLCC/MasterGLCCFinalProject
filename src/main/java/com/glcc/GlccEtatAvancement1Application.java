package com.glcc;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glcc.models.Doctorant;
import com.glcc.models.Etat_avancement;
import com.glcc.models.Professeur;
import com.glcc.models.Sujet;

import com.glcc.services.EtatService;
import com.glcc.repository.*;
@SpringBootApplication
public class GlccEtatAvancement1Application {

	@Autowired 
	private static IEtatRepository etatrepo;
	@Autowired
	private static EtatService serv;
	public static void main(String[] args) {
		SpringApplication.run(GlccEtatAvancement1Application.class, args);
		
		
/*
			 int profId = 1; // Remplacez ceci par l'ID du professeur que vous souhaitez utiliser
		     List<Etat_avancement> etats = etatrepo.findDoctorantEtatByProfId(profId);
			 
		     for (Etat_avancement etat : etats) {
		         // Accédez aux propriétés de chaque état
		         int id = etat.getIdEtat(); // Supposons que vous avez une méthode getId() dans votre classe Etat_avancement
		         String titre = etat.getTitre(); // Supposons que vous avez une méthode getTitre()
		         // Faites quelque chose avec les données de chaque état
		         System.out.println("ID : " + id + ", Titre : " + titre);
		     }*/
	}


}
