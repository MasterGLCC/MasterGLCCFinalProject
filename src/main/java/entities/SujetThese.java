package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class SujetThese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String motsCles;

    @ManyToMany(mappedBy = "sujetsThese", cascade = CascadeType.ALL)
    private List<Doctorant> doctorantsDirectes;

    // Constructors, getters, setters, and any other methods

    public SujetThese() {
        // Default constructor
    }

    // Add other constructors as needed

    // Getter and Setter methods for other fields
    // Implement getter and setter methods for other fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public List<Doctorant> getDoctorantsDirectes() {
        return doctorantsDirectes;
    }

    public void setDoctorantsDirectes(List<Doctorant> doctorantsDirectes) {
        this.doctorantsDirectes.clear();
        if (doctorantsDirectes != null) {
            this.doctorantsDirectes.addAll(doctorantsDirectes);
        }
    }
}
