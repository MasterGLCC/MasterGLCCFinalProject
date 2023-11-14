package controllers;


import dto.AbsenceDto;
import entities.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AbsenceService;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody AbsenceDto absenceDto) {
        Absence createdAbsence = absenceService.addAbsence(absenceDto);
        return new ResponseEntity<>(createdAbsence, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        Absence absence = absenceService.getAbsenceById(id);
        if (absence != null) {
            return new ResponseEntity<>(absence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDto updatedAbsenceDto) {
        Absence updatedAbsence = absenceService.updateAbsence(id, updatedAbsenceDto);
        if (updatedAbsence != null) {
            return new ResponseEntity<>(updatedAbsence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable Long id) {
        boolean deleted = absenceService.deleteAbsence(id);
        if (deleted) {
            return new ResponseEntity<>("Absence deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Absence>> getAllAbsences() {
        List<Absence> absences = absenceService.getAllAbsences();
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }
}
