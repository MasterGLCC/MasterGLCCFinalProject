package entities;

import enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("PROFESSEUR")
@AllArgsConstructor @NoArgsConstructor @Data
public class Professeur extends Personne{
    private String etablissement;
    private Grade grade;
    private String specialite;
    @ManyToOne
    private Departement departement;
    @OneToMany
    private List<SujetThese> sujetTheses;
    @ManyToMany
    List<SoutenanceThese> soutenanceTheses;
    @OneToMany
    private List<Commentaire> commentaires;
}
