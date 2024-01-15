package com.fuddelivery.converter;

import com.fuddelivery.dto.UserDto;
import com.fuddelivery.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public interface UserConverter {

    static User usertoEntityConeverter(UserDto userDto)
    {
        return User.builder().username(userDto.getUsername())
                .email(userDto.getEmail())
                .city(userDto.getCity())
                .address(userDto.getAddress())
                .password(userDto.getPassword())
                .lastName(userDto.getLastName())
                .dateOfBirth(userDto.getDateOfBirth())
                .countryCode(userDto.getCountryCode())
                .phoneNumber(userDto.getPhoneNumber())
                .city(userDto.getCity())
                .state(userDto.getState())
                .country(userDto.getCountry())
                .postalCode(userDto.getPostalCode())
                .createdAt(LocalDateTime.now())
                .createdBy("selef registration")
                .preferredLanguage("english")
                .isActive(true)
                .build();
    }
}
