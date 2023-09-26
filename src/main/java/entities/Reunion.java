package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Reunion {
    @Id
    private Integer reunionID;
    private Date date;
    private String sujet;
    private String compteRendu;
    @OneToMany
    List<Absence> listAbsences = new ArrayList<>();
    @ManyToMany
    List<Doctorant> listParticipants = new ArrayList<>();
    @OneToMany
    private List<SujetThese> sujetTheses;
}
