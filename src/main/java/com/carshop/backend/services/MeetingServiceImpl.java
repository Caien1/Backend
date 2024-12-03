package com.carshop.backend.services;

import com.carshop.backend.dao.MeetingRepository;
import com.carshop.backend.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService{
    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingServiceImpl(MeetingRepository theMeetingRepository){
        meetingRepository = theMeetingRepository;
    }


    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting findById(long id) {
        Optional<Meeting> result = meetingRepository.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("Meeting not Found");
        }
        return result.get();
    }

    @Override
    public Meeting save(Meeting theMeeting) {

        return meetingRepository.save(theMeeting);
    }

    @Override
    public void deleteById(long id) {
        meetingRepository.deleteById(id);

    }
}
