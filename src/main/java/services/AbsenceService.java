package services;

import dto.AbsenceDto;
import entities.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AbsenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    public Absence addAbsence(AbsenceDto absenceDto) {
        // Create an Absence entity from the DTO and save it
        Absence absence = new Absence();
        absence.setRaisonAbsence(absenceDto.getRaisonAbsence());
        // Set other properties as needed
        return absenceRepository.save(absence);
    }

    public Absence getAbsenceById(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    public Absence updateAbsence(Long id, AbsenceDto updatedAbsenceDto) {
        Optional<Absence> optionalAbsence = absenceRepository.findById(id);
        if (optionalAbsence.isPresent()) {
            Absence existingAbsence = optionalAbsence.get();
            existingAbsence.setRaisonAbsence(updatedAbsenceDto.getRaisonAbsence());
            // Update other properties as needed
            return absenceRepository.save(existingAbsence);
        }
        return null; // Absence not found
    }

    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    public boolean deleteAbsence(Long id) {
        Optional<Absence> optionalAbsence = absenceRepository.findById(id);
        if (optionalAbsence.isPresent()) {
            absenceRepository.delete(optionalAbsence.get());
            return true;
        }
        return false; // Absence not found
    }

    // Add more methods as needed for business logic related to Absences
}
