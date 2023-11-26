package publication.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import publication.dto.PublicationDto;
import publication.entity.Publication;
import publication.entity.Auteur;
import publication.service.PublicationServiceImpl;
import publication.service.AuteurServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Base64;
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
    public String publicationsAddAuteur(@RequestParam(value = "action", required = true) String action, @PathVariable Long id, @RequestParam Long identifiant, Model model) {
        Publication publication = publicationService.findPublicationById(id);
        Auteur auteur = auteurService.findAuteurById(identifiant);

        if (!publication.hasAuteur(auteur)) {
            publication.getAuteurs().add(auteur);
        }
        publicationService.savePublication(publication);
        model.addAttribute("publication", publicationService.findPublicationById(id));
        model.addAttribute("auteurs", auteurService.findAllAuteurs());
        return "redirect:/publications";
    }

   @RequestMapping(value = "getpublications", method = RequestMethod.GET)
   @ResponseBody
   public List<PublicationDto> getPublications() {
       List<Publication> publications = publicationService.findAllPublications();
       List<PublicationDto> publicationDtos = new ArrayList<>();

       for (Publication publication : publications) {
           PublicationDto dto = new PublicationDto();
           dto.setId(publication.getId());
           dto.setTitre(publication.getTitre());
           dto.setResume(publication.getResume());

           dto.setArticle(Base64.getEncoder().encodeToString(publication.getArticle()));
           dto.setCode(Base64.getEncoder().encodeToString(publication.getCode()));
           dto.setCertificat(Base64.getEncoder().encodeToString(publication.getCertificat()));
           publicationDtos.add(dto);
       }

       return publicationDtos;
   }
    @GetMapping("/viewFile/{id}/{fileType}")
    public ResponseEntity<Resource> viewFile(@PathVariable Long id, @PathVariable String fileType) {
        Publication publication = publicationService.findPublicationById(id);
        byte[] fileData = getFileData(publication, fileType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(getMediaType(fileType));
        headers.set("Content-Disposition", "inline");

        return new ResponseEntity<>(new ByteArrayResource(fileData), headers, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{id}/{fileType}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id, @PathVariable String fileType) {
        Publication publication = publicationService.findPublicationById(id);
        byte[] fileData = getFileData(publication, fileType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set("Content-Disposition", "attachment; filename=" + getFileName(publication, fileType));

        return new ResponseEntity<>(new ByteArrayResource(fileData), headers, HttpStatus.OK);
    }

    private byte[] getFileData(Publication publication, String fileType) {
        switch (fileType) {
            case "article":
                return publication.getArticle();
            case "code":
                return publication.getCode();
            case "certificat":
                return publication.getCertificat();
            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }

    private MediaType getMediaType(String fileType) {
        switch (fileType) {
            case "article":
            case "certificat":
                return MediaType.APPLICATION_PDF;
            case "code":

            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }

    private String getFileName(Publication publication, String fileType) {
        switch (fileType) {
            case "article":
                return "article.pdf";
            case "code":
                return "code.zip";
            case "certificat":
                return "certificat.zip";
            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }
}

