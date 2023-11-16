package com.MGLC.activitesdoctorants.controllers;

import com.MGLC.activitesdoctorants.dto.DoctorantDto;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MGLC.activitesdoctorants.services.DoctorantService;

import java.util.List;

@RestController
@RequestMapping("/doctorants")
public class DoctorantController {
    private final Logger LOGGER = LoggerFactory.getLogger(DoctorantController.class);
    @Autowired
    private DoctorantService doctorantService;

    @PostMapping("/save")
    public ResponseEntity<Doctorant> createDoctorant(@RequestBody DoctorantDto doctorantDto) {
        Doctorant createdDoctorant = doctorantService.addDoctorant(doctorantDto);
        LOGGER.info("*************SAVE ***************");
        return new ResponseEntity<>(createdDoctorant, HttpStatus.CREATED);
        //test object method post
//        {
//            "id": null,
//                "apogee": "57896",
//                "nom": "khadija",
//                "prenom": "glpu",
//                "cne": "EM11223",
//                "directeurThese":1
//        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctorant> getDoctorantById(@PathVariable Long id) {
        Doctorant doctorant = doctorantService.getDoctorantById(id);
        LOGGER.info("*************GET BY ID ***************");
        if (doctorant != null) {
            return new ResponseEntity<>(doctorant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctorant> updateDoctorant(@PathVariable Long id, @RequestBody DoctorantDto updatedDoctorantDto) {
        Doctorant updatedDoctorant = doctorantService.updateDoctorant(id, updatedDoctorantDto);
        LOGGER.info("*************UPDATE BY ID ***************");
        if (updatedDoctorant != null) {
            return new ResponseEntity<>(updatedDoctorant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorant(@PathVariable Long id) {
        boolean deleted = doctorantService.deleteDoctorant(id);
        LOGGER.info("*************DELETE BY ID ***************");
        if (deleted) {
            return new ResponseEntity<>("Doctorant deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctorant not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Doctorant>> getAllDoctorants() {
        LOGGER.info("*************GET ALL ***************");
        List<Doctorant> doctorants = doctorantService.getAllDoctorants();
        return new ResponseEntity<>(doctorants, HttpStatus.OK);
    }
}
