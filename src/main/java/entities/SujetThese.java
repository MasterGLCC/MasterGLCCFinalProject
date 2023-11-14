package entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "sujetThese")
public class SujetThese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String motsCles;

//    @ManyToMany
//    @JoinTable(
//            name = "doctorant_sujet",
//            joinColumns = @JoinColumn(name = "sujet_id"),
//            inverseJoinColumns = @JoinColumn(name = "doctorant_id")
//    )
    //   private List<Doctorant> doctorantsDirectes;

}




