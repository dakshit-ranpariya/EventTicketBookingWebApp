package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String registerUser(User user) {
        userRepo.save(user);
        return "Register Successfully";
    }

    public String signIn(User user) {
        userRepo.save(user);
        return "Login Successfully";
    }
}
