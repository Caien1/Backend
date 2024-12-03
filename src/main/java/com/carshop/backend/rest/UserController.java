package com.carshop.backend.rest;

import com.carshop.backend.entity.Car;
import com.carshop.backend.entity.Meeting;
import com.carshop.backend.entity.User;
import com.carshop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController{
private UserService userService;

@Autowired
    public UserController(UserService theUserService){
    userService = theUserService;
}
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long userId){
        User theUser = userService.findById(userId);
        if (theUser==null){
            throw new RuntimeException("This User Doesnt exist");
        }
        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){
        theUser.setUserId(0L);
        User dbUser = userService.save(theUser);
        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser){
        User dbUser = userService.save(theUser);
        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteCar(@PathVariable long id){
        userService.deleteById(id);

    }

}
