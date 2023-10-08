package com.MGLC.activitesdoctorants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EtatDto {
    private String title;
    private String desc;
    private String date;
    private int evaluation;
}
