package publication.service;

import publication.entity.Publication;
import publication.repository.PublicationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl {


    private final PublicationRepository repository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository repository) {
        this.repository = repository;
    }

    public Publication findPublicationById(Long id) {
        return repository.findById(id).orElse(new Publication());
    }

    public List<Publication> findAllByOrderByTitreAsc() {
        return repository.findAllByOrderByTitreAsc();
    }

    public void savePublication(Publication publication) {
        repository.save(publication);
    }

    public void updatePublication(Publication publication) {
        repository.save(publication);
    }

    public void deletePublicationById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllPublications() {
        repository.deleteAll();
    }

    public List<Publication> findAllPublications() {
        return (List<Publication>) repository.findAll();
    }

}
