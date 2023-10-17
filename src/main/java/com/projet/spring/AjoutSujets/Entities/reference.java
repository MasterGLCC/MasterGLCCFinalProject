package com.projet.spring.AjoutSujets.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@Table(name="reference")
public class reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int reference_id;
    private String auteur;
    private String titre;
    private String anneeEdition;

    @Enumerated(EnumType.STRING)
    private ReferenceType referenceType;
    public enum ReferenceType {
        LIVRE,
        ARTICLE,
        VIDEO    }

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private sujetThese sujet;

}
