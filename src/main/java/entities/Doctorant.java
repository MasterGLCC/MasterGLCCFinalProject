package entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "doctorant")
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

//    @ManyToOne
//    @JoinColumn(name = "directeur_id")
//    private Professeur directeurThese;

//    @ManyToMany
//    @JoinTable(
//            name = "doctorant_sujet",
//            joinColumns = @JoinColumn(name = "doctorant_id"),
//            inverseJoinColumns = @JoinColumn(name = "sujet_id")
//    )
//    private List<SujetThese> sujetsThese;


}
