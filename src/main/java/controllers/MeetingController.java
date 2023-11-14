package controllers;


import dto.MeetingDto;
import entities.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MeetingService;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody MeetingDto meetingDto) {
        Meeting createdMeeting = meetingService.createMeeting(meetingDto);
        return new ResponseEntity<>(createdMeeting, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        Meeting meeting = meetingService.getMeetingById(id);
        if (meeting != null) {
            return new ResponseEntity<>(meeting, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> updateMeeting(@PathVariable Long id, @RequestBody MeetingDto updatedMeetingDto) {
        Meeting updatedMeeting = meetingService.updateMeeting(id, updatedMeetingDto);
        if (updatedMeeting != null) {
            return new ResponseEntity<>(updatedMeeting, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeeting(@PathVariable Long id) {
        boolean deleted = meetingService.deleteMeeting(id);
        if (deleted) {
            return new ResponseEntity<>("Meeting deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Meeting not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        List<Meeting> meetings = meetingService.getAllMeetings();
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }
}
