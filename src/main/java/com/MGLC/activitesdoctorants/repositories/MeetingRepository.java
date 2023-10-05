package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    // Add custom query methods if needed
}
