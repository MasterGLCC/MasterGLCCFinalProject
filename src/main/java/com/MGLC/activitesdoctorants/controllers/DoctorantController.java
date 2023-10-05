package com.MGLC.activitesdoctorants.controllers;

import com.MGLC.activitesdoctorants.dto.DoctorantDto;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.services.DoctorantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctorants")
public class DoctorantController {

    @Autowired
    private DoctorantService doctorantService;

    @PostMapping
    public ResponseEntity<Doctorant> createDoctorant(@RequestBody DoctorantDto doctorantDto) {
        Doctorant createdDoctorant = doctorantService.addDoctorant(doctorantDto);
        return new ResponseEntity<>(createdDoctorant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctorant> getDoctorantById(@PathVariable Long id) {
        Doctorant doctorant = doctorantService.getDoctorantById(id);
        if (doctorant != null) {
            return new ResponseEntity<>(doctorant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctorant> updateDoctorant(@PathVariable Long id, @RequestBody DoctorantDto updatedDoctorantDto) {
        Doctorant updatedDoctorant = doctorantService.updateDoctorant(id, updatedDoctorantDto);
        if (updatedDoctorant != null) {
            return new ResponseEntity<>(updatedDoctorant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorant(@PathVariable Long id) {
        boolean deleted = doctorantService.deleteDoctorant(id);
        if (deleted) {
            return new ResponseEntity<>("Doctorant deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctorant not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Doctorant>> getAllDoctorants() {
        List<Doctorant> doctorants = doctorantService.getAllDoctorants();
        return new ResponseEntity<>(doctorants, HttpStatus.OK);
    }
}
