package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEMBRE-JURY")
@AllArgsConstructor @NoArgsConstructor @Data
public class MembreJury extends Professeur{
    private String role;
}
