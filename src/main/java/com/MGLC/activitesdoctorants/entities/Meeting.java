package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String location;

    @Column
    private String description;

    @Column
    private String compteRendu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorant_id")
    private Doctorant doctorant;

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", compteRendu='" + compteRendu + '\'' +
                ", doctorant=" + doctorant +
                '}';
    }

// Constructors, getters, setters, and any other methods


}
