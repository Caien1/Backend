package com.carshop.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    //buyer id foreign key
    private Long buyerId;
    private Long sellerId;
    private Long carId;


    //
    private String location;
    private LocalDateTime meetingTime;

    @Enumerated(EnumType.STRING)
    private MeetingStatus status;



}

enum MeetingStatus {
    SCHEDULED, COMPLETE, CANCELED
}