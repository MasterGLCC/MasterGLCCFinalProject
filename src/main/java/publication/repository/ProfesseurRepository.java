package publication.repository;

import org.springframework.data.repository.CrudRepository;
import publication.entity.Auteur;
import publication.entity.Professeur;

public interface ProfesseurRepository extends CrudRepository<Professeur, Long> {
}
