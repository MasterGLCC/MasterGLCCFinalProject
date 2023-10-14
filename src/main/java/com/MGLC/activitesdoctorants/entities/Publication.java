package com.MGLC.activitesdoctorants.entities;

import com.MGLC.activitesdoctorants.enums.PublicationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Publication {
    @Id
    private Integer publicationID;
    private String titre;
    private String resume;
    private String articlePdf;
    private String CodeSourceZip;
    @ManyToMany
    private List<Auteur> auteurs = new ArrayList<>();
    private PublicationType publicationType;
}
