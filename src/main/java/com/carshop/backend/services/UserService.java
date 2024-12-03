package com.carshop.backend.services;

import com.carshop.backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User save(User theUser);
    void deleteById(long id);

}
