package publication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publication.entity.Professeur;;
import publication.repository.ProfesseurRepository;

import java.util.List;

@Service
public class ProfesseurServiceImpl {
    private final ProfesseurRepository professeurRepository;
    @Autowired
    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public Professeur findProfesseurById(Long id) {
        return professeurRepository.findById(id).orElse(new Professeur());
    }

    public void saveProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    public void updateProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    public void deleteProfesseurById(Long id) {
        professeurRepository.deleteById(id);
    }

    public void deleteAllProfesseurs() {
        professeurRepository.deleteAll();
    }

    public List<Professeur> findAllProfesseurs() {
        return (List<Professeur>) professeurRepository.findAll();
    }

}
