package com.MGLC.activitesdoctorants.dto;

import com.MGLC.activitesdoctorants.enums.PublicationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {
    private String title;

    private String resume;

    private String articlePDF;
    private String codeSourceZIP;
    private String CertificatePDF;

    private PublicationType publicationType;
}
