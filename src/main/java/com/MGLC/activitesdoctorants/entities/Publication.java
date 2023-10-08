package com.MGLC.activitesdoctorants.entities;

import com.MGLC.activitesdoctorants.enums.PublicationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PublicationId")
    private Long id;
    @Column(name = "Titre")
    private String title;
    @Column(name = "Resume")
    private String resume;
    @Column(name = "ArticlePDF")
    private String articlePDF;
    @Column(name = "CodeSourceZip")
    private String codeSourceZIP;
    @Column(name = "CertificatPDF")
    private String CertificatePDF;

    @Column(name = "PublicationType")
    private PublicationType publicationType;
    @ManyToMany
    private List<Personne> auteur = new ArrayList<>();
}
