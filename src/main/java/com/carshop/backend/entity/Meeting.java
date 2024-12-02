package com.carshop.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Meeting {

    @Id
    private Long meetingId;


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