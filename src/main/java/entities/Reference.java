package entities;

import enums.ReferenceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Reference {
    @Id
    private Integer referenceID;
    @OneToOne
    private Auteur auteur;
    private String titre;
    private Date anneEdition;
    @ManyToOne
    private SujetThese sujetThese;
    private ReferenceType referenceType;
}
