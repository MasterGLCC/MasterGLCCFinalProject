package com.projet.spring.AjoutSujets.DTO;

import com.projet.spring.AjoutSujets.Entities.reference;
import com.projet.spring.AjoutSujets.Entities.sujetThese;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SujetRequest {
    private sujetThese sujetThese;
    private List<reference> references;

}
