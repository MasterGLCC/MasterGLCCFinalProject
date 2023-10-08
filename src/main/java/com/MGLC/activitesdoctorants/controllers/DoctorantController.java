package com.MGLC.activitesdoctorants.controllers;


import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.services.DoctorantServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class DoctorantController {

    private final DoctorantServiceImp doctorantService;

    @GetMapping("/doctorants")
    public String listStudents(Model model) {
        List<Doctorant> doctorants = doctorantService.loadDoctorants();
        // for (Doctorant doctorant : doctorants) {
        // System.out.println("oppoge" + doctorant.getApogee());
        // }
        model.addAttribute("doctorants", doctorants);
        return "doctorant/list";
    }
}
