package com.MGLC.activitesdoctorants.controllers;


import com.MGLC.activitesdoctorants.dto.AbsenceDto;
import com.MGLC.activitesdoctorants.entities.Absence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MGLC.activitesdoctorants.services.AbsenceService;

import java.util.List;

@RestController
@RequestMapping("/absence")
public class AbsenceController {
    private final Logger LOGGER = LoggerFactory.getLogger(AbsenceController.class);
    @Autowired
    private AbsenceService absenceService;

    @PostMapping("/save")
    public ResponseEntity<Absence> createAbsence(@RequestBody AbsenceDto absenceDto) {
        LOGGER.info("*************SAVE ***************");
        Absence createdAbsence = absenceService.addAbsence(absenceDto);
        return new ResponseEntity<>(createdAbsence, HttpStatus.CREATED);
        /* Objet test post
            {
            "id": null,
            "meetingId": 1,
            "doctorantId":2,
            "reason": "raison absence8",
            "raisonAbsence": "raison absence8"
            }        */
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        Absence absence = absenceService.getAbsenceById(id);
        LOGGER.info("*************GET BY ID ***************");
        if (absence != null) {
            return new ResponseEntity<>(absence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDto updatedAbsenceDto) {
        Absence updatedAbsence = absenceService.updateAbsence(id, updatedAbsenceDto);
        LOGGER.info("*************UPDATE BY ID ***************");
        if (updatedAbsence != null) {
            return new ResponseEntity<>(updatedAbsence, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable Long id) {
        boolean deleted = absenceService.deleteAbsence(id);
        LOGGER.info("*************DELETE BY ID ***************");
        if (deleted) {
            return new ResponseEntity<>("Absence deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Absence>> getAllAbsences() {
        List<Absence> absences = absenceService.getAllAbsences();
        LOGGER.info("************* GET ALL ***************");
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }
    @GetMapping("/test")
    public String testAPI() {
        return "Test";
    }
}
