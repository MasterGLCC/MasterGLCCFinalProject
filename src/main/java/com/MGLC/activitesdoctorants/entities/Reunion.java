package com.MGLC.activitesdoctorants.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reunion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReunionId")
    private Long id;
    @NotNull
    @Column(name = "Date")
    private Instant date;
    @Column(name = "Sujet")
    private String sujet;
    @Column(name = "CompteRendu")
    private String compteRendu;

    @OneToMany(mappedBy = "reunion")
    private List<Absence> listAbsence = new ArrayList<>();

    @ManyToMany(mappedBy = "reunions")
    private List<Doctorant> listParticipants = new ArrayList<>();
}
