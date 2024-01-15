package com.fuddelivery.controller;

import com.fuddelivery.converter.UserConverter;
import com.fuddelivery.dto.UserDto;
import com.fuddelivery.entity.User;
import com.fuddelivery.repo.UserRepo;
import com.fuddelivery.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    private UserRepo userRepo;




    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto)
    {
        try {

            String b = userService.userAlreadyExist(userDto.getEmail());
            if (b!=null) {
                return ResponseEntity.status(HttpStatus.OK).body("user is already registeretd");
            }
                User user = UserConverter.usertoEntityConeverter(userDto);
            String registrationMessage = userService.saveuser(user);

            if( registrationMessage!=null)
            {
                return ResponseEntity.status(HttpStatus.CREATED).body("the user registration id completed");
            }

        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SOMETHING_WENT_WRONG");
    }
}
