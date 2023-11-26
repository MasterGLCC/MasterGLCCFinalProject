package publication.repository;

import publication.entity.Auteur;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur, Long> {


}
