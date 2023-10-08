package com.MGLC.activitesdoctorants.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorantPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "publication")
    private Publication publication;
    @ManyToOne
    @JoinColumn(name = "doctorant")
    private Doctorant doctorant;
}
