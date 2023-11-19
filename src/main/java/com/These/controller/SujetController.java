package com.These.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.These.entity.Sujet;
import com.These.entity.Reference;
import com.These.service.ReferenceService;
import com.These.service.SujetService;



@Controller
public class SujetController {
	@Autowired
	private SujetService sujetservice;
	@Autowired
	private ReferenceService rService;
	
	
	@GetMapping("/")
	public String home() {
		return "professeur";
	}
	
	@GetMapping("/sujetRegister")
	public String sujetRegister() {
		return "sujetRegister";
	}
	

    @PostMapping("/saveSujet")
    public String addSujetWithReferences(@ModelAttribute Sujet sujet) {
    	if (sujet.getListeReferences() != null) {
            for (Reference reference : sujet.getListeReferences()) {
                reference.setSujet(sujet);
            }
        }
        sujetservice.saveSujet(sujet);           	
        return "redirect:/affichage";
    }
    
    
  
    @GetMapping("/affichage")
	public String getAllSujet(Model model)
	{
		List<Sujet>list=sujetservice.getAllSujet();
		model.addAttribute("sujet",list);
		return "affichage";
	}
    
    @RequestMapping("/editSujet/{id}")
   	public String editBook(@PathVariable("id") int id,Model model) {
   		Sujet s=sujetservice.getSujetById(id);
   		model.addAttribute("sujet",s);
   		return "sujetEdit";
   	}
   	@RequestMapping("/deleteSujet/{id}")
   	public String deleteSujet(@PathVariable("id")int id) {
   		sujetservice.deleteById(id);
   		return "redirect:/affichage";
   	}
    
    @GetMapping("/afficherReferences/{id}")
	public String getAllReference(@PathVariable("id") int id,Model model)
	{	
        Sujet sujet = sujetservice.getSujetById(id);
        if (sujet != null) {
            List<Reference> references = sujet.getListeReferences();
            model.addAttribute("references", references);
            model.addAttribute("sujet", sujet);
        }    	
		return "afficherReferences";
	}
    
    @PostMapping("/save")
    public String addReferences(@ModelAttribute Reference r) {
        rService.save(r);
        return "redirect:/affichage";
    }
    
    
   	
    
    
    @RequestMapping("/afficherReferences/{id}/editReference/{referenceId}")
    public String editReference(@PathVariable("id") int id, @PathVariable("referenceId") int referenceId, Model model) {
        Reference r = rService.getReferenceById(referenceId);
        Sujet sujet = sujetservice.getSujetById(id); // Récupérez le sujet
        model.addAttribute("sujet", sujet); // Ajoutez le sujet au modèle
        model.addAttribute("reference", r);
        return "referenceEdit";
    }

   	@RequestMapping("/deleteReference/{id}")
   	public String deleteReference(@PathVariable("id") int id) {
   	    rService.deleteById(id);
   	    return "redirect:/affichage";
   	}
   	





   
}
