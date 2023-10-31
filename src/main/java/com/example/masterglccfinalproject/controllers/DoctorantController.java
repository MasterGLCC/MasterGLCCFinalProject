package com.example.masterglccfinalproject.controllers;

import com.example.masterglccfinalproject.entities.Doctorant;
import com.example.masterglccfinalproject.entities.Professeur;
import com.example.masterglccfinalproject.entities.SujetThese;
import com.example.masterglccfinalproject.services.DoctorantService;
import com.example.masterglccfinalproject.services.ProfesseurService;
import com.example.masterglccfinalproject.services.SujetTheseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DoctorantController {
    private ProfesseurService professeurService;
    private SujetTheseService sujetTheseService;
    private DoctorantService doctorantService;

    public DoctorantController(ProfesseurService professeurService, SujetTheseService sujetTheseService, DoctorantService doctorantService) {
        this.professeurService = professeurService;
        this.sujetTheseService = sujetTheseService;
        this.doctorantService = doctorantService;
    }

    @GetMapping("/DoctorantManagement")
    public String listDoctorants(Model model) {

        model.addAttribute("doctorants",doctorantService.getAllDoctorants());
        return "DoctorantManagement";
    }
    @GetMapping("/doctorants/new")
    public String createDoctorantForm(Model model) {
        List<Professeur> professeurs = professeurService.getAllProfesseurs();
        List<SujetThese> sujetsThese = sujetTheseService.getAllSujetThese();
        model.addAttribute("professeurs", professeurService.getAllProfesseurs());
        model.addAttribute("sujetsThese", sujetTheseService.getAllSujetThese());
        Doctorant doctorant=new Doctorant();
        model.addAttribute("doctorant", doctorant);
        return "AjoutDoctorant";
    }

    @PostMapping("/DoctorantManagement")
    public String enregistrerDoctorant(@ModelAttribute("doctorant") Doctorant doctorant) {
        doctorantService.enregistrerDoctorant(doctorant);

        return "redirect:/DoctorantManagement";
    }

    @GetMapping("/doctorants/modif/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("doctorant",doctorantService.getDoctorantById(id));
        List<Professeur> professeurs = professeurService.getAllProfesseurs();
        List<SujetThese> sujetsThese = sujetTheseService.getAllSujetThese();
        model.addAttribute("professeurs", professeurService.getAllProfesseurs());
        model.addAttribute("sujetsThese", sujetTheseService.getAllSujetThese());
        return "ModifDoctorant";
    }



   @PostMapping("/doctorants/{id}")
   public String modifierDoctorant(@PathVariable Long id,
                                   @ModelAttribute("doctorant") Doctorant doctorant,
                                   Model model) {

       // Obtenir le doctorant existant à partir de la base de données
       Doctorant existingDoctorant = doctorantService.getDoctorantById(id);

       // Mettre à jour les champs de l'objet existingDoctorant avec les valeurs du formulaire
       existingDoctorant.setNom(doctorant.getNom());
       existingDoctorant.setPrenom(doctorant.getPrenom());
       existingDoctorant.setCin(doctorant.getCin());
       existingDoctorant.setPhoto(doctorant.getPhoto());
       existingDoctorant.setEmail(doctorant.getEmail());
       existingDoctorant.setAdresse(doctorant.getAdresse());
       existingDoctorant.setApogee(doctorant.getApogee());
       existingDoctorant.setCne(doctorant.getCne());

       // Obtenir l'encadrant et les co-encadrants sélectionnés dans le formulaire
       Professeur encadrant = professeurService.getProfesseurById(doctorant.getEncadrant().getIdentifiant());
       List<Professeur> coEncadrants = doctorant.getCoEncadrants().stream()
               .map(coEncadrant -> professeurService.getProfesseurById(coEncadrant.getIdentifiant()))
               .collect(Collectors.toList());

       existingDoctorant.setEncadrant(encadrant);
       existingDoctorant.setCoEncadrants(coEncadrants);

       // Obtenir le sujet de thèse sélectionné dans le formulaire
       SujetThese sujetThese = sujetTheseService.getSujetTheseById(doctorant.getSujetThese().getSujetTheseID());
       existingDoctorant.setSujetThese(sujetThese);

       // Enregistrer les modifications
       doctorantService.modifierDoctorant(existingDoctorant);
       return "redirect:/DoctorantManagement";
   }


    @GetMapping("/doctorants/{id}")
    public String SupprimerDoctorant(@PathVariable Long id) {
        doctorantService.supprimerDoctorantById(id);
        return "redirect:/DoctorantManagement";
    }


}
