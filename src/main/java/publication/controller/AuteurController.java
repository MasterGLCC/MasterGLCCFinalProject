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
import publication.service.AuteurServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuteurController {

    @Autowired
    private AuteurServiceImpl auteurService;

    @RequestMapping("auteurs")
    public String index(Model model) {
        List<Auteur> auteurs = (List<Auteur>) auteurService.findAllByOrderByRoleAsc();
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
    public String editAuteur(@PathVariable("id") Long auteurId, Model model) {
        model.addAttribute("auteur", auteurService.findAuteurById(auteurId));
        model.addAttribute("titre", "Modifier Auteur");
        return "auteurForm";
    }

    @RequestMapping("auteur/{id}")
    public String showAuteur(@PathVariable("id") Long auteurId, Model model) {
        model.addAttribute("auteur", auteurService.findAuteurById(auteurId));
        model.addAttribute("titre", "Afficher Auteur");
        return "auteurShow";
    }

    @RequestMapping(value = "saveAuteur", method = RequestMethod.POST)
    public String saveAuteur(@Valid @ModelAttribute("auteur") Auteur auteur, BindingResult bindingResult, @RequestParam("auteurid") Long auteurId, Model model) {
        if (!bindingResult.hasErrors()) {
            auteurService.saveAuteur(auteur);
        } else {
            String title = (auteurId == null) ? "Ajouter Auteur" : "Modifier Auteur";
            model.addAttribute("titre", title);
            return "auteurForm";
        }
        return "redirect:/auteurs";
    }

    @RequestMapping(value = "auteur/delete/{id}", method = RequestMethod.GET)
    public String deleteAuteur(@PathVariable("id") Long auteurId, Model model) {
        auteurService.deleteAuteurById(auteurId);
        return "redirect:/auteurs";
    }

}
