package publication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Blob;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Entity
public class Publication{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 3, message = "titre  est invalide")
    private String titre;

    @Size(min = 3, message = "resume est invalide")
    private String resume;

    private byte[] article;

    private byte[] code;

    private byte[] certificat;

    private Set<Auteur> auteurs = new HashSet<Auteur>(0);

    public Publication() {
        // Default constructor is needed by Hibernate
    }

    public Publication(String titre, String resume, byte[] article, byte[] code,byte[] certificat ) {
        super();
        this.titre = titre;
        this.resume = resume;
        this.article = article;
        this.code = code;
        this.certificat =certificat;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Column(name = "resume")
    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }
    @Column(name = "article")
    @Lob
    public byte[] getArticle() {return article;}
    public void setArticle(byte[] article) {this.article = article;}


    @Column(name = "code")
    @Lob
    public byte[] getCode() {return code;}
    public void setCode(byte[] code) {this.code = code;}

    @Column(name = "certificat")
    @Lob
    public byte[] getCertificat() {return certificat;}
    public void setCertificat(byte[] certificat) {this.certificat = certificat;}


    /*@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "publication_auteur", joinColumns = {
        @JoinColumn(name = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "auteurid")
    })*/
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "publication_auteurs", joinColumns = {
            @JoinColumn(name = "publication_id")}, inverseJoinColumns = {
            @JoinColumn(name = "auteurid")
    })
    public Set<Auteur> getAuteurs() {
        return this.auteurs;
    }

    public void setAuteurs(Set<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    public boolean hasAuteur(Auteur auteur) {
        for (Auteur publicationAuteur : getAuteurs()) {
            if (publicationAuteur.getIdentifiant() == auteur.getIdentifiant()) {
                return true;
            }
        }
        return false;
    }


}
