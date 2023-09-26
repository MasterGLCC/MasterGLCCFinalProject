package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "personne_type")
@AllArgsConstructor @NoArgsConstructor @Data
public class Personne {
    @Id
    private Integer identifiant;
    private String nom;
    private String prenom;
    private String photo;
    private String email;
    private String login;
    private String motDePasse;
    private String adresse;
    @OneToMany
    private List<AxeRecherche> axeRecherches;
    @OneToMany
    private List<Message> messages;
}
