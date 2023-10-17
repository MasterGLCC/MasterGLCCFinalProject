package com.projet.spring.AjoutSujets.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Builder
@Table(name="sujet_these")
public class sujetThese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sujet_id")
    private  Long sujet_id;
    private String titre;
    private String description;
    private String mots_cles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sujet")
    private List<reference> References;
}
