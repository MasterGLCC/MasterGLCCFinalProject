package dto;

public class SujetTheseDto {

    private String titre;
    private String description;
    private String motsCles;

    public SujetTheseDto() {
    }

    public SujetTheseDto(String titre, String description, String motsCles) {
        this.titre = titre;
        this.description = description;
        this.motsCles = motsCles;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getMotsCles() {
        return motsCles;
    }

    // Implement getters and setters for other properties if needed

    @Override
    public String toString() {
        return "SujetTheseDto{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", motsCles='" + motsCles + '\'' +
                '}';
    }
}
