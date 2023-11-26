package publication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publication.entity.Auteur;
import publication.entity.Doctorant;
import publication.repository.DoctorantRepository;

import java.util.List;

@Service
public class DoctorantServiceImpl {

    private final DoctorantRepository doctorantRepository;
    @Autowired
    public DoctorantServiceImpl(DoctorantRepository doctorantRepository) {
        this.doctorantRepository = doctorantRepository;
    }

    public Doctorant findDoctorantById(Long id) {
        return doctorantRepository.findById(id).orElse(new Doctorant());
    }

    public void saveDoctorant(Doctorant doctorant) {
        doctorantRepository.save(doctorant);
    }

    public void updateDoctorant(Doctorant doctorant) {
        doctorantRepository.save(doctorant);
    }

    public void deleteDoctorantById(Long id) {
        doctorantRepository.deleteById(id);
    }

    public void deleteAllDoctorants() {
        doctorantRepository.deleteAll();
    }

    public List<Doctorant> findAllDoctorants() {
        return (List<Doctorant>) doctorantRepository.findAll();
    }

}

