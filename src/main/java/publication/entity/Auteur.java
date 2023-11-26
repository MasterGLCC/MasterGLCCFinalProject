package publication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "auteur_type", discriminatorType = DiscriminatorType.STRING)
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;
    private String nom;
    private String prenom;
    @Column(name = "auteur_type", insertable = false, updatable = false)
    private String auteurType;
    @ManyToMany(mappedBy = "auteurs")
    private Set<Publication> publications;


}