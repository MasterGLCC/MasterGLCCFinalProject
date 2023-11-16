package com.MGLC.activitesdoctorants.services;

import com.MGLC.activitesdoctorants.dto.AbsenceDto;
import com.MGLC.activitesdoctorants.entities.Absence;
import com.MGLC.activitesdoctorants.repositories.DoctorantRepository;
import com.MGLC.activitesdoctorants.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MGLC.activitesdoctorants.repositories.AbsenceRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private DoctorantRepository doctorantRepository;
    @Autowired
    private MeetingRepository meetingRepository;
    public Absence addAbsence(AbsenceDto absenceDto) {
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        // Create an Absence entity from the DTO and save it
        Absence absence = new Absence();
        absence.setRaisonAbsence(absenceDto.getRaisonAbsence());
        absence.setDate(localDateTime);
        absence.setDoctorant(doctorantRepository.findById(absenceDto.getDoctorantId()).get());
        absence.setMeeting(meetingRepository.findById(absenceDto.getMeetingId()).get());
        absence.setReason(absenceDto.getReason());

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
