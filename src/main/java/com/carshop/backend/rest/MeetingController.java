package com.carshop.backend.rest;

import com.carshop.backend.entity.Car;
import com.carshop.backend.entity.Meeting;
import com.carshop.backend.services.CarService;
import com.carshop.backend.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MeetingController {

    private MeetingService meetingService;

    @Autowired
    public  MeetingController(MeetingService theMeetingService){
        meetingService= theMeetingService;
    }

    @GetMapping("/meetings")
    public List<Meeting> getAllMeetings(){
        return meetingService.findAll();
    }


    @GetMapping("/meetings/{meetingId}")
    public Meeting getMeeting(@PathVariable long meetingId){
        Meeting  theMeeting = meetingService.findById(meetingId);
        if (theMeeting==null){
            throw new RuntimeException("This Meeting Doesnt exist");
        }
        return theMeeting;
    }

    @PostMapping("/meetings")
    public Meeting  addMeeting(@RequestBody Meeting theMeeting){
        theMeeting.setMeetingId(0L);
        Meeting  dbMeeting = meetingService.save(theMeeting);
        return dbMeeting;
    }

    @PutMapping("/meetings")
    public Meeting  updateMeeting(@RequestBody Meeting theMeeting){
        Meeting  dbMeeting = meetingService.save(theMeeting);
        return dbMeeting;
    }

    @DeleteMapping("/meetings/{meetingId}")
    public void deleteMeeting(@PathVariable long id){
        meetingService.deleteById(id);

    }


}
