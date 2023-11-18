package publication.service;

import publication.entity.Auteur;
import publication.repository.AuteurRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurServiceImpl {

    @Autowired
    private final AuteurRepository repository;

    @Autowired
    public AuteurServiceImpl(AuteurRepository repository) {
        this.repository = repository;
    }

    public Auteur findAuteurById(Long auteurid) {
        return repository.findById(auteurid).orElse(new Auteur());
    }

    public List<Auteur> findAllByOrderByRoleAsc() {
        return repository.findAllByOrderByRoleAsc();
    }

    public void saveAuteur(Auteur auteur) {
        repository.save(auteur);
    }

    public void updateAuteur(Auteur auteur) {
        repository.save(auteur);
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
