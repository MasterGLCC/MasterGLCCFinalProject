package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorant_id")
    private Doctorant doctorant;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String raisonAbsence;

    public Absence() {
        // Default constructor
    }
    public String getRaisonAbsence() {
        return raisonAbsence;
    }

    public void setRaisonAbsence(String raisonAbsence) {
        this.raisonAbsence = raisonAbsence;
    }
    // Getters and setters

    // Additional methods, if needed
}
