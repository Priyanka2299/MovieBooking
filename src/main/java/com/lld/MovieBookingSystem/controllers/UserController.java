package com.lld.MovieBookingSystem.controllers;

import com.lld.MovieBookingSystem.dtos.ResponseStatus;
import com.lld.MovieBookingSystem.dtos.SignUpRequestDTO;
import com.lld.MovieBookingSystem.dtos.SignUpResponseDTO;
import com.lld.MovieBookingSystem.models.Users;
import com.lld.MovieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpResponseDTO signUp(SignUpRequestDTO request){
        SignUpResponseDTO response = new SignUpResponseDTO();
        try{
            Users user = userService.signUp(request.getEmail(), request.getPassword());
            response.setUserId(user.getId());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("User successfully registered");
        }catch (Exception ex){
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
