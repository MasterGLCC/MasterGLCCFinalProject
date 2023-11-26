package publication.repository;

import org.springframework.data.repository.CrudRepository;
import publication.entity.Auteur;
import publication.entity.Doctorant;

public interface DoctorantRepository extends CrudRepository<Doctorant, Long> {
}
