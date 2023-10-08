package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("doctorant")
public class Doctorant extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Apogee")
    private String apogee;
    @Column(name = "CNE")
    private String cne;

    @ManyToMany
    @JoinTable(name = "doctorant_reunion", joinColumns = @JoinColumn(name = "doctorant_id"), inverseJoinColumns = @JoinColumn(name = "reunion_id"))
    private List<Reunion> reunions = new ArrayList<>();

    @OneToOne(mappedBy = "doctorant")
    private SujetThese sujetThese;

}
