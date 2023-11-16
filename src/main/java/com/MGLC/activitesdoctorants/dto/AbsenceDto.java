package com.MGLC.activitesdoctorants.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AbsenceDto {

    private String raisonAbsence;
    private Long doctorantId;
    private Long meetingId;
    private String reason;
    // Constructors, getters, setters, and any other methods

    public AbsenceDto() {
        // Default constructor
    }

}
