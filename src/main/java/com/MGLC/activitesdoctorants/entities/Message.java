package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
@AllArgsConstructor @NoArgsConstructor @Data
public class Message {
    @Id
    private Integer messageID;
    private String contenu;
    @ManyToOne
    private Personne personne;
    @ManyToOne
    private Forum forum;
}
