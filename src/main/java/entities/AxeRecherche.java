package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class AxeRecherche {

    @Id
    private Integer axesRechercheID;
    private String description;
    private String titre;
    @ManyToOne
    private Personne personne;
}

