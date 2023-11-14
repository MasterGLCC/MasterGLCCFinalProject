package services;


import dto.DoctorantDto;
import entities.Doctorant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DoctorantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorantService {

    @Autowired
    private DoctorantRepository doctorantRepository;

    public Doctorant addDoctorant(DoctorantDto doctorantDto) {
        // Convert DoctorantDto to Doctorant entity
        Doctorant doctorant = new Doctorant();
        doctorant.setApogee(doctorantDto.getApogee());
        doctorant.setCNE(doctorantDto.getCNE());
        // Set other properties if needed

        return doctorantRepository.save(doctorant);
    }

    public List<Doctorant> getAllDoctorants() {
        return doctorantRepository.findAll();
    }

    public Doctorant getDoctorantById(Long id) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        return optionalDoctorant.orElse(null);
    }

    public Doctorant updateDoctorant(Long id, DoctorantDto updatedDoctorantDto) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        if (optionalDoctorant.isPresent()) {
            Doctorant doctorant = optionalDoctorant.get();
            doctorant.setApogee(updatedDoctorantDto.getApogee());
            doctorant.setCNE(updatedDoctorantDto.getCNE());
            // Update other properties if needed

            return doctorantRepository.save(doctorant);
        }
        return null; // Doctorant not found
    }

    public boolean deleteDoctorant(Long id) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        if (optionalDoctorant.isPresent()) {
            doctorantRepository.delete(optionalDoctorant.get());
            return true;
        }
        return false; // Doctorant not found
    }
}
