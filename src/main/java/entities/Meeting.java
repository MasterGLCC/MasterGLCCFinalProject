package entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@ToString
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String location;

    // Add more fields as needed
    // For example:
    @Column
    private String description;

    @Column
    private String compteRendu;

    // Constructors, getters, setters, and any other methods

    public Meeting() {
        // Default constructor
    }

    // Add other constructors as needed
    public Meeting(String subject, LocalDateTime dateTime, String location) {
        this.subject = subject;
        this.dateTime = dateTime;
        this.location = location;
    }

    // Getter and Setter methods for other fields
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    // Implement getter and setter methods for other fields

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Implement getter and setter methods for other fields
}
