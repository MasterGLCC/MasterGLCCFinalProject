package dto;

import java.time.LocalDateTime;

public class MeetingDto {

    private String subject;
    private LocalDateTime dateTime;
    private String location;

    // Constructors, getters, setters, and any other methods

    public MeetingDto() {
        // Default constructor
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Implement getters and setters for other properties

    // Constructors, getters, setters, and any other methods
}
