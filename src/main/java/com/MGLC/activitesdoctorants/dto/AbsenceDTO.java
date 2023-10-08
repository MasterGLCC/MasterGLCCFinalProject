package com.MGLC.activitesdoctorants.dto;

import com.MGLC.activitesdoctorants.enums.Année;
import lombok.Data;

@Data
public class AbsenceDTO {
    Année année;
    int nombreReunion;
    int nombreAbsence;
}
