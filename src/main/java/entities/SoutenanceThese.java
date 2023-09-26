package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class SoutenanceThese {
    @Id
    private Integer soutenanceID;
    private Date dateSoutenance;
    @ManyToMany
    private List<Professeur> listJury;
    private float noteSoutenance;
    @OneToMany
    private List<MembreJury> membreJuries;
}
