package publication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import publication.enums.Grade;

import javax.persistence.*;
import java.util.Set;


@Data

@Entity
@DiscriminatorValue("PROFESSEUR")
public class Professeur extends Auteur{

    private String etablissement;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String specialite;

    public Professeur() {
    }

    public Professeur(Long identifiant, String nom, String prenom, String auteurType, Set<Publication> publications, String etablissement, Grade grade, String specialite) {
        super(identifiant, nom, prenom, auteurType, publications);
        this.etablissement = etablissement;
        this.grade = grade;
        this.specialite = specialite;
    }
}