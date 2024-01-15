package com.fuddelivery.service;

import com.fuddelivery.entity.User;
import com.fuddelivery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public String saveuser(User user) {

         String str = String.valueOf(userRepo.save(user));

         return "Succesfull registered";

    }

    @Override
    public String userAlreadyExist(String email) {

        User user1 = userRepo.findByEmailOrUserName(email);

        if (user1==null)
            return "Not registered ";
        else
            return " the user is already registered";

    }
}
