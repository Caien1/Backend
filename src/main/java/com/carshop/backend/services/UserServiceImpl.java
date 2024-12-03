package com.carshop.backend.services;

import com.carshop.backend.dao.UserRepository;
import com.carshop.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("THE USER DOESEN'T EXIst");
        }
        return result.get();
    }

    @Override
    public User save(User theUser) {
       // userRepository.save(user);


        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(long id) {

        userRepository.deleteById(id);


    }
}
