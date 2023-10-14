package com.MGLC.activitesdoctorants.controllers;

import com.MGLC.activitesdoctorants.dto.RechercheResponse;
import com.MGLC.activitesdoctorants.services.recherche.RechercheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class Recherche {

    private final RechercheService rechercheService;

    @GetMapping("/")
    public String get(Model model) {
        return "recherche_barre";
    }

    @PostMapping("/recherche")
    public String recherche(@ModelAttribute("cle") String cle, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("cle", cle);
        RechercheResponse response = rechercheService.recherche(cle, 0, 3);
        (model).addAttribute("professeurs", response.getProfesseurs());
        (model).addAttribute("doctorants", response.getDoctorants());
        (model).addAttribute("sujetThese", response.getSujetThese());
        (model).addAttribute("profSize", response.getProfesseurs().size());
        (model).addAttribute("doctSize", response.getDoctorants().size());
        (model).addAttribute("sujSize", response.getSujetThese().size());
        return "landing_Results";
    }

    @PostMapping("/all")
    public String all(@ModelAttribute("type") String type, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String cle = (String) session.getAttribute("cle");
        (model).addAttribute("cle", cle);
        session.setAttribute("type", type);
        RechercheResponse response = rechercheService.recherche(cle, 0, 10);

        if (Objects.equals(type, "d")){
            (model).addAttribute("type", "d");
            (model).addAttribute("doctorants", response.getDoctorants());
            (model).addAttribute("size", response.getDoctorants().size());
        } else if (Objects.equals(type, "p")) {
            (model).addAttribute("type", "p");
            (model).addAttribute("professeurs", response.getProfesseurs());
            (model).addAttribute("size", response.getProfesseurs().size());
        } else if (Objects.equals(type, "t")) {
            (model).addAttribute("type", "t");
            (model).addAttribute("sujetThese", response.getSujetThese());
            (model).addAttribute("size", response.getSujetThese().size());
        }
        Long count = rechercheService.count(cle, type);
        (model).addAttribute("count", count);
        (model).addAttribute("pas", Integer.valueOf("1"));
        (model).addAttribute("page", 1);
        return "all_results";
    }

    @GetMapping("/all/{page}")
    public String allBypage(@PathVariable String page, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String cle = (String) session.getAttribute("cle");
        (model).addAttribute("cle", cle);
        String type = (String) session.getAttribute("type");
        Integer pageNum = Integer.parseInt(page);
        System.out.println(pageNum);
        int firstResult = (pageNum - 1) * 10;
        int lastResult = pageNum * 10;

        RechercheResponse response = rechercheService.recherche(cle, firstResult, lastResult);
        if (Objects.equals(type, "d")){
            (model).addAttribute("type", "d");
            (model).addAttribute("size", response.getDoctorants().size());
            (model).addAttribute("doctorants", response.getDoctorants());
        } else if (Objects.equals(type, "p")) {
            (model).addAttribute("type", "p");
            (model).addAttribute("professeurs", response.getProfesseurs());
            (model).addAttribute("size", response.getProfesseurs().size());
        } else if (Objects.equals(type, "t")) {
            (model).addAttribute("type", "t");
            (model).addAttribute("sujetThese", response.getSujetThese());
            (model).addAttribute("size", response.getSujetThese().size());
        }

        Long count = rechercheService.count(cle, type);
        (model).addAttribute("count", count);
        (model).addAttribute("pas", Integer.valueOf("1"));
        (model).addAttribute("page", pageNum);

        return "all_results";
    }
}
