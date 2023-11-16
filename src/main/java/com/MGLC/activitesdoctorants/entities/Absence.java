package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorant_id")
    private Doctorant doctorant;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String raisonAbsence;

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", meeting=" + meeting +
                ", doctorant=" + doctorant +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                ", raisonAbsence='" + raisonAbsence + '\'' +
                '}';
    }
}
