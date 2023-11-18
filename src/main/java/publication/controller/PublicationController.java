package publication.controller;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import publication.entity.Publication;
import publication.entity.Auteur;
import publication.service.PublicationServiceImpl;
import publication.service.AuteurServiceImpl;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import java.math.BigInteger;
import java.util.List;

@Controller
public class PublicationController {

    @Autowired
    private PublicationServiceImpl publicationService;

    @Autowired
    private AuteurServiceImpl auteurService;




    @RequestMapping("publications")
    public String index(Model model) {
        List<Publication> publications = (List<Publication>) publicationService.findAllByOrderByTitreAsc();
        model.addAttribute("publications", publications);
        return "publications";
    }

    @RequestMapping(value = "publication/new")
    public String newPublication(Model model) {
        model.addAttribute("publication", new Publication());
        model.addAttribute("titre", "Ajouter Publication");
        return "publicationForm";
    }

    @RequestMapping(value = "publication/edit/{id}")
    public String editPublication(@PathVariable("id") Long publicationtId, Model model) {
        model.addAttribute("publication", publicationService.findPublicationById(publicationtId));
        model.addAttribute("titre", "Modifer Publication");
        return "publicationForm";
    }

    public static class ByteUtils {

        public static String bytesToHex(byte[] bytes) {
            BigInteger bigInt = new BigInteger(1, bytes);
            return String.format("%0" + (bytes.length << 1) + "x", bigInt);
        }
    }

    @RequestMapping("publication/{id}")
    public String showPublication(@PathVariable("id") Long publicationtId, Model model) {
        model.addAttribute("publication", publicationService.findPublicationById(publicationtId));
        model.addAttribute("titre", "Afficher Publication");
        return "publicationShow";
    }

    @PostMapping(value = "savePublication", consumes = {"multipart/form-data"})
    public String savePublication(
            @Valid @ModelAttribute("publication") Publication publication,
            BindingResult bindingResult,
            @RequestParam("id") Long publicationId,
            @RequestParam("article") MultipartFile articleFile,
            @RequestParam("code") MultipartFile codeFile,
            @RequestParam("certificat") MultipartFile certificatFile,
            Model model
    ) {
        try {

            if (articleFile != null && !articleFile.isEmpty()) {
                byte[] articleBytes = articleFile.getBytes();
                publication.setArticle(articleBytes);
            }else {
                publication.setArticle(null);
            }

            if (codeFile != null && !codeFile.isEmpty()) {
                byte[] codeBytes = codeFile.getBytes();
                publication.setCode(codeBytes);
            }else {
                publication.setCode(null);
            }
            if (certificatFile != null && !certificatFile.isEmpty()) {
                byte[] certificatBytes = certificatFile.getBytes();
                publication.setCertificat(certificatBytes);
            }else {
                publication.setCertificat(null);
            }
            publicationService.savePublication(publication);

        } catch (MaxUploadSizeExceededException e) {
            bindingResult.reject("file", e.getMessage());
            return "publicationForm";}
        catch (Exception e) {
            e.printStackTrace();
            return "publicationForm";
        }
        return "redirect:/publications";
    }


    @RequestMapping(value = "publication/delete/{id}", method = RequestMethod.GET)
    public String deletePublication(@PathVariable("id") Long publicationtId, Model model) {
        publicationService.deletePublicationById(publicationtId);
        return "redirect:/publications";
    }

    @RequestMapping(value = "addPublicationAuteur/{id}", method = RequestMethod.GET)
    public String addPublicationAuteur(@PathVariable("id") Long publicationtId, Model model) {
        model.addAttribute("publication", publicationService.findPublicationById(publicationtId));
        model.addAttribute("auteurs", auteurService.findAllAuteurs());
        return "addPublicationAuteur";
    }

    @RequestMapping(value = "publication/{id}/auteurs", method = RequestMethod.GET)
    public String publicationsAddAuteur(@RequestParam(value = "action", required = true) String action, @PathVariable Long id, @RequestParam Long auteurId, Model model) {
        Publication publication = publicationService.findPublicationById(id);
        Auteur auteur = auteurService.findAuteurById(auteurId);

        if (!publication.hasAuteur(auteur)) {
            publication.getAuteurs().add(auteur);
        }
        publicationService.savePublication(publication);
        model.addAttribute("publication", publicationService.findPublicationById(id));
        model.addAttribute("auteurs", auteurService.findAllAuteurs());
        return "redirect:/publications";
    }

    @RequestMapping(value = "getpublications", method = RequestMethod.GET)
    public @ResponseBody
    List<Publication> getpublications() {
        return (List<Publication>) publicationService.findAllPublications();
    }
}

