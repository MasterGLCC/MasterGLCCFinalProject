package publication.repository;

import publication.entity.Publication;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, Long> {

    Publication findByTitre(String titre);
    List<Publication> findAllByOrderByTitreAsc();

}
