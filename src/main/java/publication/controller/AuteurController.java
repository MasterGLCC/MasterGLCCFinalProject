package publication.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import publication.entity.Auteur;
import publication.entity.Doctorant;
import publication.entity.Professeur;
import publication.enums.Grade;
import publication.service.AuteurServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import publication.service.DoctorantServiceImpl;
import publication.service.ProfesseurServiceImpl;

@Controller
public class AuteurController {


    private AuteurServiceImpl auteurService;
    @Autowired
    private DoctorantServiceImpl doctorantService;
    @Autowired
    private ProfesseurServiceImpl professeurService;
    @Autowired
    public AuteurController(AuteurServiceImpl auteurService) {
        this.auteurService = auteurService;
    }


    @RequestMapping("auteurs")
    public String index(Model model) {
        List<Auteur> auteurs = (List<Auteur>) auteurService.findAllAuteurs();
        model.addAttribute("auteurs", auteurs);
        return "auteurs";
    }

    @RequestMapping(value = "auteur/new")
    public String newAuteur(Model model) {
        model.addAttribute("auteur", new Auteur());
        model.addAttribute("titre", "Ajouter Auteur");
        return "auteurForm";
    }

    @RequestMapping(value = "auteur/edit/{id}")
    public String editAuteur(@PathVariable("id") Long identifiant, Model model) {
        model.addAttribute("auteur", auteurService.findAuteurById(identifiant));
        model.addAttribute("titre", "Modifier Auteur");
        return "auteurForm";
    }

    @RequestMapping("auteur/{id}")
    public String showAuteur(@PathVariable("id") Long identifiant, Model model) {
        model.addAttribute("auteur", auteurService.findAuteurById(identifiant));
        model.addAttribute("titre", "Afficher Auteur");
        return "auteurShow";
    }

//    @RequestMapping(value = "saveAuteur", method = RequestMethod.POST)
//    public String saveAuteur(@Valid @ModelAttribute("auteur") Auteur auteur, BindingResult bindingResult, @RequestParam("auteurid") Long auteurId, Model model) {
//        if (!bindingResult.hasErrors()) {
//            auteurService.saveAuteur(auteur);
//        } else {
//            String title = (auteurId == null) ? "Ajouter Auteur" : "Modifier Auteur";
//            model.addAttribute("titre", title);
//            return "auteurForm";
//        }
//        return "redirect:/auteurs";
//    }

@RequestMapping(value = "/saveAuteur", method = RequestMethod.POST)
public String saveAuteur(@Valid @ModelAttribute("auteur") Auteur auteur,
                         BindingResult bindingResult,
                         @RequestParam("identifiant") Long identifiant,
                         @RequestParam(name = "apogee", required = false) String apogee,
                         @RequestParam(name = "cne", required = false) String cne,
                         @RequestParam(name = "etablissement", required = false) String etablissement,
                         @RequestParam(name = "grade", required = false) Grade grade,
                         @RequestParam(name = "specialite", required = false) String specialite,
                         Model model) {

    if (!bindingResult.hasErrors()) {
        if (auteur.getIdentifiant() == null) {
            // Si l'identifiant est null, il s'agit d'un nouvel auteur
            if ("DOCTORANT".equals(auteur.getAuteurType())) {
                Doctorant doctorant = new Doctorant();
                doctorant.setNom(auteur.getNom());
                doctorant.setPrenom(auteur.getPrenom());
                doctorant.setAuteurType(auteur.getAuteurType());
                doctorant.setApogee(apogee);
                doctorant.setCne(cne);
                doctorantService.saveDoctorant(doctorant);
            } else if ("PROFESSEUR".equals(auteur.getAuteurType())) {
                Professeur professeur = new Professeur();
                professeur.setNom(auteur.getNom());
                professeur.setPrenom(auteur.getPrenom());
                professeur.setAuteurType(auteur.getAuteurType());
                professeur.setEtablissement(etablissement);
                professeur.setGrade(grade);
                professeur.setSpecialite(specialite);
                professeurService.saveProfesseur(professeur);
            }
        } else {
            // Si l'identifiant existe, c'est une modification
            Auteur existingAuteur = auteurService.findAuteurById(auteur.getIdentifiant());

            if (existingAuteur != null) {
                // Mettez à jour les propriétés en fonction du type d'auteur
                existingAuteur.setNom(auteur.getNom());
                existingAuteur.setPrenom(auteur.getPrenom());
                existingAuteur.setAuteurType(auteur.getAuteurType());

                if ("DOCTORANT".equals(auteur.getAuteurType())) {
                    ((Doctorant) existingAuteur).setApogee(apogee);
                    ((Doctorant) existingAuteur).setCne(cne);
                    doctorantService.updateDoctorant((Doctorant) existingAuteur);
                } else if ("PROFESSEUR".equals(auteur.getAuteurType())) {
                    ((Professeur) existingAuteur).setEtablissement(etablissement);
                    ((Professeur) existingAuteur).setGrade(grade);
                    ((Professeur) existingAuteur).setSpecialite(specialite);
                    professeurService.updateProfesseur((Professeur) existingAuteur);
                }


            }
        }

        return "redirect:/auteurs";
    } else {
        // Gérer les erreurs de validation
        String title = (auteur.getIdentifiant() == null) ? "Ajouter Auteur" : "Modifier Auteur";
        model.addAttribute("titre", title);
        return "auteurForm";
    }
}



    @RequestMapping(value = "auteur/delete/{id}", method = RequestMethod.GET)
    public String deleteAuteur(@PathVariable("id") Long identifiant, Model model) {
        auteurService.deleteAuteurById(identifiant);
        return "redirect:/auteurs";
    }

}
