package com.glcc.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.glcc.services.EtatService;
import com.glcc.services.FichierServiceImplimentation;
import com.glcc.services.SujetService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.glcc.services.CommentaireService;
import com.glcc.services.DoctorantService;
import com.glcc.models.Etat_avancement;
import com.glcc.models.Fichier;
import com.glcc.models.Sujet;
import com.glcc.repository.IEtatRepository;
import com.glcc.repository.IFichierRepostory;
import com.glcc.models.Commentaire;
import com.glcc.models.Doctorant;
@Controller
public class EtatController {

	@Autowired
	private EtatService service;
	@Autowired
	private CommentaireService cservice;
	
	@Autowired
	private SujetService Sservice;
	
	@Autowired
	private DoctorantService Dservice;
	
	@Autowired
	private IEtatRepository repo;
	
	@Autowired
	FichierServiceImplimentation fichieServiceImplementation;
	@Autowired
	IFichierRepostory fichierRepository;
	
	@GetMapping("/etats/{id}")
	public String getAllEtats(Model model,@PathVariable("id") Long id) {
		model.addAttribute("liste",service.getAllEtatByProf(id));
		//model.addAttribute("message", message);
		List<Object[]> liste = service.getAllEtatByProf(id);
        model.addAttribute("data", liste);
        return "Professeur/listeEtats";
	}
	
	@GetMapping("/home/{id}")
	public String getHome(Model model,@PathVariable("id") Long id) {
		
        return "nav";
	}
	
	
	@GetMapping("/etats/edit/{id}")
	public String detailsEtats(@PathVariable("id") Long id,Model model) {
		model.addAttribute("etat",service.getAllEtatByProf(id));
		model.addAttribute("sujet",service.getSujetByEtat(id));
		model.addAttribute("etats",service.getEtatBySujet(id));
		model.addAttribute("ett",service.getEtatById(id));
		model.addAttribute("comm", new Commentaire());
		List<Etat_avancement> etatsAvancement = service.getEtatByIdTh(id); // Récupérer les données par idTh
	    model.addAttribute("etatsAvancement", etatsAvancement);
		return "Professeur/edit";
	}
	
	
	@PostMapping("/etats/edit/{id}/note")
	public String modifierNote(@PathVariable Long id, @ModelAttribute("etat") Etat_avancement etat, Model model) {
		Etat_avancement existEtat = service.getEtatById(id);
		existEtat.setNote(etat.getNote());
		service.modifierNote(existEtat);
		return "redirect:/etats/edit/{id}";
	}
	
	@PostMapping("/etats/edit/{id}/addCmt")
	public String commenter(@PathVariable Long id, @RequestParam String commentaire) {
		
		cservice.ajoutCommentaire(commentaire,id);
		return "redirect:/etats/edit/{id}";
	}
	
	@GetMapping("/addetat/{id}")
	public String getHome(@PathVariable Long id, Model model) {
	    // Ajoutez la valeur de "id" à l'objet Model pour l'envoyer à la vue
	    model.addAttribute("id", id);
		//model.addAttribute("ett",Sservice.gettheseByiddoc(id));
	    return "doctorant/addetat";
	}
	@PostMapping("/addetat/{id}/save_Etat")
	public String saveetat(@PathVariable Long id, @ModelAttribute Etat_avancement etat_avancement, @RequestParam String titre, @RequestParam String Description,  HttpServletRequest request,@RequestParam("file") MultipartFile file, @RequestParam("file") MultipartFile[] files, HttpSession session, Model modal) {
	    etat_avancement.setDate(LocalDate.now());
				etat_avancement.setDate(LocalDate.now());
				//etat_avancement.setStatus("En cours");
			    //String idParam = request.getParameter("id");
			    //Long id = Long.parseLong(idParam);

			        Sujet sujet = Sservice.getsujetbyid(id);
			        //etat_avancement.setIdEtat((long) 2);
			        etat_avancement.setTitre(titre);
			        etat_avancement.setDescription(Description);
			        etat_avancement.setSujet(sujet);
			    
				
		//	int	idth = Sujetrepo.findDoctorantidtheseByiddoctorant(idFromForm);

				repo.save(etat_avancement);
		
				if (!file.isEmpty()) {
		            try {
		                // Vous pouvez enregistrer le fichier dans la base de données ou dans un système de fichiers
		                // Ici, nous supposons que vous l'enregistrez dans la base de donnée
				        List<Fichier> fileList = new ArrayList<Fichier>();
			           
		            	  for (MultipartFile fil : files) {
		  		        	
		  		            String fileContentType = fil.getContentType();
		  		            byte[] sourceFileContent = fil.getBytes();
		  		            String fileName = fil.getOriginalFilename();
		  		            Fichier fileModel = new Fichier();
		  		            fileModel.setName(fileName);
		  		            fileModel.setType(fileContentType);
		  		            fileModel.setData(sourceFileContent);
		  		            fileModel.setEtat(etat_avancement);
		  		            // Adding file into fileList
		  		            fileList.add(fileModel);
		  		            }
		  		       
		  		            // Saving all the list item into database
		  		        fichieServiceImplementation.saveAllFilesList(fileList);
		  		 
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
				

				
				session.setAttribute("mssg", "Votre Etat est bien ajouté");

				// Redirigez vers la page /etat?iddoc={iddoc}
				return "redirect:/addetat/{id}";
}
	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
	    // Récupérez le fichier à partir de la base de données en utilisant fileId
	    Fichier fichier = fichieServiceImplementation.getFileById(id);

	    if (fichier != null) {
	        // Créez une ByteArrayResource à partir des données du fichier
	        ByteArrayResource resource = new ByteArrayResource(fichier.getData());

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fichier.getName())
	                .contentLength(fichier.getData().length)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(resource);
	    } else {
	        // Gérez le cas où le fichier n'a pas été trouvé
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	  
	
}

