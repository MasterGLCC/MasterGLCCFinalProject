package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany(mappedBy = "sujetsThese", cascade = CascadeType.ALL)
    private List<Doctorant> doctorantsDirectes;

    @Override
    public String toString() {
        return "SujetThese{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", motsCles='" + motsCles + '\'' +
                ", doctorantsDirectes=" + doctorantsDirectes +
                '}';
    }

    // Constructors, getters, setters, and any other methods

}
