package com.carshop.backend.services;

import com.carshop.backend.entity.Meeting;

import java.util.List;

public interface MeetingService {
    List<Meeting> findAll();
    Meeting findById(long id);
    Meeting save(Meeting theMeeting);
    void deleteById(long id);

}
