package com.MGLC.activitesdoctorants.entities;

import com.MGLC.activitesdoctorants.enums.ProfessorGrade;
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
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Etablissement")
    private String etablissement;
    @Column(name = "Grade")
    private ProfessorGrade grade;
    @Column(name = "Specialite")
    private String speciality;
}
