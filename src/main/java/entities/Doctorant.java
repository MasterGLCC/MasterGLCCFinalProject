package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctorant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apogee;

    @Column(name = "CNE", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'DefaultCNEValue'")
    private String CNE;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "directeur_id")
    private Professeur directeurThese;

    @OneToMany(mappedBy = "doctorant")
    private List<Meeting> meetings;

    @OneToMany(mappedBy = "doctorant")
    private List<Absence> absences;

    @ManyToMany
    @JoinTable(
            name = "doctorant_sujet",
            joinColumns = @JoinColumn(name = "doctorant_id"),
            inverseJoinColumns = @JoinColumn(name = "sujet_id")
    )
    private List<SujetThese> sujetsThese;

    // Constructors, getters, setters, and any other methods

    public Doctorant() {
        // Default constructor
    }

    // Add other constructors as needed

    // Getter and Setter methods for other fields
    // Implement getter and setter methods for other fields

    public String getApogee() {
        return apogee;
    }

    public void setApogee(String apogee) {
        this.apogee = apogee;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public Professeur getDirecteurThese() {
        return directeurThese;
    }

    public void setDirecteurThese(Professeur directeurThese) {
        this.directeurThese = directeurThese;
    }

    public List<SujetThese> getSujetsThese() {
        return sujetsThese;
    }

    public void setSujetsThese(List<SujetThese> sujetsThese) {
        this.sujetsThese = sujetsThese;
    }
}
