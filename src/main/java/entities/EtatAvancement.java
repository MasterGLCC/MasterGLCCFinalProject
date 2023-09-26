package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class EtatAvancement {
    @Id
    private Integer etatAvancementID;
    private Date date;
    private String titre;
    private String description;
    private String evaluation;
    @ManyToOne
    private SujetThese sujetThese;
    @ManyToMany
    private List<Commentaire> commentaires;
}
