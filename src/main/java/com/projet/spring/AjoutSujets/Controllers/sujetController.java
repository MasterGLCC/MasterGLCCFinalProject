package com.projet.spring.AjoutSujets.Controllers;
import com.projet.spring.AjoutSujets.DTO.sujetResponse;
import com.projet.spring.AjoutSujets.Entities.reference;
import com.projet.spring.AjoutSujets.Entities.sujetThese;
import com.projet.spring.AjoutSujets.Services.referenceService;
import com.projet.spring.AjoutSujets.Services.sujetService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@NoArgsConstructor
@RequestMapping("/")
public class sujetController {
    @Autowired
    public sujetService sujetServ;
    @Autowired
    public referenceService referenceServ;

    public sujetController(sujetService sujetServ, referenceService referenceServ){
        this.sujetServ=sujetServ;
        this.referenceServ=referenceServ;
    }

    // Retourner la vue d'acceuil
    @GetMapping("/acceuil")
    public String getAcceuil(){
        return "Acceuil";

    }

    // Retourner la liste des sujets
    @GetMapping("/")
    public String getAllSujet(Model model){
        List<sujetResponse> sujets= sujetServ.getAllSujet();
        model.addAttribute("sujets", sujets);
        return "Sujet_Liste";

    }
    //Retourner le formulaire d'ajout
    @GetMapping("/sujet_form")
    public String getForm(Model model){
        model.addAttribute("sujetThese", new sujetThese());
        return "ajout_form";
    }
    // Enregistrer les données de sujet dans la base de donnée
    @PostMapping("/ajouterSujet")
    public String createSujet(sujetThese sujetThese, @RequestParam(required = false) List<reference> references, Model model) {
        try {
            sujetThese sujet = sujetServ.createSujet(sujetThese);
            sujet.setReferences(references);
            model.addAttribute("sujet", sujet);
            model.addAttribute("references", references);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while creating sujet.");
            return "error_page";
        }
    }

    //Retourner le formulaire de modification
    @RequestMapping(path = {"/update", "/update/{sujet_id}"})
    public String showUpdateForm(@PathVariable("sujet_id") String sujetId, Model model) {
        System.out.println("editsujetById: " + sujetId);
        Long sujetIdAsLong = null;
        if (sujetId != null && !sujetId.isEmpty()) {
            try {
                sujetIdAsLong = Long.parseLong(sujetId);
            } catch (NumberFormatException e) {
            }
        }

        if (sujetIdAsLong != null) {
            sujetThese sujet = sujetServ.getSujetById(sujetIdAsLong);
            model.addAttribute("sujet", sujet);

        }

        return "sujet_update_form";
    }


    //modifier un sujet
    @PutMapping("/updateSujet/{sujet_id}")
    public String updateSujet(
            @PathVariable("sujet_id") Long sujet_id,
            @ModelAttribute("sujet") sujetThese sujet
    ) {
        sujet.setSujet_id(sujet_id);
        sujetServ.updateSujet(sujet);
        return "redirect:/";
    }
    //Supprimer un sujet
    @DeleteMapping("/deleteSujet/{sujet_id}")
    public String deleteSujet(@PathVariable("sujet_id") Long sujet_id) {
        sujetServ.deleteSujet(sujet_id);
        return "redirect:/";
    }
}

