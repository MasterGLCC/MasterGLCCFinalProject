package com.projet.spring.AjoutSujets.DTO;

import com.projet.spring.AjoutSujets.Entities.reference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@ResponseStatus
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class sujetResponse{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long sujet_id;
        private String titre;
        private String description;
        private String mots_cles;
        @OneToMany
        private List<reference> References;
}
