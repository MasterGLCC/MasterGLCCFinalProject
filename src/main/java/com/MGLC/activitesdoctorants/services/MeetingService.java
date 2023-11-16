package com.MGLC.activitesdoctorants.services;

import com.MGLC.activitesdoctorants.dto.MeetingDto;
import com.MGLC.activitesdoctorants.entities.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MGLC.activitesdoctorants.repositories.MeetingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public Meeting createMeeting(MeetingDto meetingDto) {
        Meeting meeting = new Meeting();
        meeting.setSubject(meetingDto.getSubject());
        meeting.setDateTime(meetingDto.getDateTime());
        meeting.setLocation(meetingDto.getLocation());
        // You can set other properties as needed
        return meetingRepository.save(meeting);
    }

    public Meeting getMeetingById(Long meetingId) {
        return meetingRepository.findById(meetingId).orElse(null);
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Meeting updateMeeting(Long meetingId, MeetingDto updatedMeetingDto) {
        Optional<Meeting> optionalMeeting = meetingRepository.findById(meetingId);
        if (optionalMeeting.isPresent()) {
            Meeting existingMeeting = optionalMeeting.get();
            existingMeeting.setSubject(updatedMeetingDto.getSubject());
            existingMeeting.setDateTime(updatedMeetingDto.getDateTime());
            existingMeeting.setLocation(updatedMeetingDto.getLocation());
            // Update other properties as needed
            return meetingRepository.save(existingMeeting);
        }
        return null; // Meeting not found
    }

    public boolean deleteMeeting(Long meetingId) {
        Optional<Meeting> optionalMeeting = meetingRepository.findById(meetingId);
        if (optionalMeeting.isPresent()) {
            Meeting existingMeeting = optionalMeeting.get();
            meetingRepository.delete(existingMeeting);
            return true;
        }
        return false; // Meeting not found
    }
}
