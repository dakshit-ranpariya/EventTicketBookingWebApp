package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    //hiii
    @PostMapping("register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public String signIn(@RequestBody User user){
        return userService.signIn(user);
    }
}
