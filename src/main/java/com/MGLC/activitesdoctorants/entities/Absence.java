package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ReunionId")
    private Reunion reunion;
    @Column(name = "DoctorantID")
    private Long doctorant;
    @Column(name = "RaisonAbsence")
    private String raisonAbsence;

}
