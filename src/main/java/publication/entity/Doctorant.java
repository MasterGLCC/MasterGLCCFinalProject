package publication.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
 @Data
@Entity
 @DiscriminatorValue("DOCTORANT")
public class Doctorant extends Auteur {
    private String apogee;
    private String cne;

     public Doctorant() {
     }

     public Doctorant(Long identifiant, String nom, String prenom, String auteurType, Set<Publication> publications, String apogee, String cne) {
         super(identifiant, nom, prenom, auteurType, publications);
         this.apogee = apogee;
         this.cne = cne;
     }
 }