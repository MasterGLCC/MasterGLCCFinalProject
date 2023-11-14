package dto;

public class AbsenceDto {

    private String raisonAbsence;
    private Long doctorantId; // Add a property for doctorant ID if needed

    // Constructors, getters, setters, and any other methods

    public AbsenceDto() {
        // Default constructor
    }

    public String getRaisonAbsence() {
        return raisonAbsence;
    }

    public void setRaisonAbsence(String raisonAbsence) {
        this.raisonAbsence = raisonAbsence;
    }

    // Add getters and setters for the new property
    public Long getDoctorantId() {
        return doctorantId;
    }

    public void setDoctorantId(Long doctorantId) {
        this.doctorantId = doctorantId;
    }

    // Other getters and setters for other properties

    // Constructors, setters, and other methods
}
