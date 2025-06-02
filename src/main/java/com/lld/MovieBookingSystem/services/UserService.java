package com.lld.MovieBookingSystem.services;

import com.lld.MovieBookingSystem.controllers.UserController;
import com.lld.MovieBookingSystem.models.Users;
import com.lld.MovieBookingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public Users signUp(
            String email,
            String password
    ){
        Optional<Users> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User already Registered! Please login");
        }
        Users user = new Users();
        user.setEmail(email);
        user.setBookings(new ArrayList<>());
        user.setPassword(password);
        user.setName("Temp Name");

        return userRepository.save(user);

    }
}
