package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EtatAvancement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EtatAvancementId")
    private Long id;

    @Column(name = "Date")
    private Instant date;
    @Column(name = "Titre")
    private String title;
    @Column(name = "Description", length = 400)
    private String description;
    @Column(name = "Evaluation")
    private int evaluation;
    @ManyToOne
    @JoinColumn(name = "sujetThese")
    private SujetThese sujetThese;
}
