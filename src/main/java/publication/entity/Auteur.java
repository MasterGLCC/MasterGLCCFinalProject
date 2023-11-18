package publication.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auteurid")
    private Long auteurid;

    @Size(min = 3, message = "Auteur est invalide")
    @Column(name = "role")
    private String role;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_contribution")
    private Date dateContribution;

    @ManyToMany(mappedBy = "auteurs")
    private Set<Publication> publications;

    public Auteur() {
    }

    public Auteur(String role, Date dateContribution) {
        this.role = role;
        this.dateContribution = dateContribution;

    }

    public Long getAuteurid() {
        return auteurid;
    }
    
    public void setAuteurid(Long auteurid) {
        this.auteurid = auteurid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateContribution() {
        return dateContribution;
    }
    public void setDateContribution(Date dateContribution) {
        this.dateContribution = dateContribution;
    }
    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }
}
