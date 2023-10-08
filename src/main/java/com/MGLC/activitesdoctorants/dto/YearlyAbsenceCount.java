package com.MGLC.activitesdoctorants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class YearlyAbsenceCount {
    private int date;
    private long absences;
    private long total;
}
