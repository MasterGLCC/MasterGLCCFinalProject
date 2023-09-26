package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Diplome {
    @Id
    private Integer diplomeID;
    private String anneObtention;
    private String etablisement;
    private String intitule;
    @ManyToOne
    private DossierDoctorant dossierDoctorant;
}
