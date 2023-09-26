package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class DossierDoctorant {
    @Id
    private Integer dossierID;
    private String numeroReference;
    @OneToOne
    private SujetThese sujetThese;
    @OneToOne
    private Doctorant doctorant;
    @OneToMany
    private List<Diplome> diplomes;
}
