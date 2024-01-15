package com.fuddelivery.service;

import com.fuddelivery.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    String saveuser(User user);
    String userAlreadyExist(String email);
}
