package com.fuddelivery.service;

import com.fuddelivery.Exception.RolesNotFound;
import com.fuddelivery.entity.Roles;
import com.fuddelivery.entity.User;
import com.fuddelivery.repo.RolesRepo;
import com.fuddelivery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RolesRepo rolesRepo;
    @Override
    public String saveuser(User user) {

        Set<Roles> rolesSet = new HashSet<>();
        Roles roles =  rolesRepo.findByName("User1").get();

        if(roles==null)
        {
            throw new RolesNotFound("the mentioned roles to the user is not found ");
        }

        rolesSet.add(roles);
        user.setRoles(rolesSet);
         String str = String.valueOf(userRepo.save(user));

         return "Succesfull registered";

    }

    @Override
    public String userAlreadyExist(String email) {

        User user1 = userRepo.findByEmailOrUserName(email);

       if (user1 == null)
       {
           return null;
       }
       else return "not null";

    }
}
