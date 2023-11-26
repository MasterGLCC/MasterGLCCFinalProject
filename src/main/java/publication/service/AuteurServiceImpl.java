package publication.service;

import publication.entity.Auteur;
import publication.entity.Doctorant;
import publication.entity.Professeur;
import publication.repository.AuteurRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publication.repository.DoctorantRepository;
import publication.repository.ProfesseurRepository;

@Service
public class AuteurServiceImpl {


    private final AuteurRepository repository;

    @Autowired
    private final DoctorantRepository doctorantRepository;

    private final ProfesseurRepository professeurRepository;
    @Autowired
    public AuteurServiceImpl(AuteurRepository repository, DoctorantRepository doctorantRepository, ProfesseurRepository professeurRepository) {
        this.repository = repository;
        this.doctorantRepository = doctorantRepository;
        this.professeurRepository = professeurRepository;
    }

    public Auteur findAuteurById(Long auteurid) {
        return repository.findById(auteurid).orElse(new Auteur());
    }


    public void saveDoctorant(Doctorant auteur) {
        repository.save(auteur);
    }
    public void saveProfesseur(Professeur auteur) {
        professeurRepository.save(auteur);
    }

    public void updateDoctorant(Doctorant auteur) {
        doctorantRepository.save(auteur);
    }

    public void updateProfesseur(Professeur auteur) {
        professeurRepository.save(auteur);
    }

    public void deleteAuteurById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllAuteurs() {
        repository.deleteAll();
    }

    public List<Auteur> findAllAuteurs() {
        return (List<Auteur>) repository.findAll();
    }

}
