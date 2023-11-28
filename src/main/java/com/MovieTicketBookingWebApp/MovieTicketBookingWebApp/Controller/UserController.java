package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.DTO.ResetDTO;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public String registerUser(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public String signIn(@RequestParam String userEmail, @RequestParam String userPassword) throws NoSuchAlgorithmException {
        return userService.signIn(userEmail, userPassword);
    }

    @GetMapping("signout")
    public String signOut(@RequestParam String userEmail){
        return userService.signoutUser(userEmail);
    }

    @PostMapping("resetPassword")
    private String resetPassword(@RequestParam String userEmail){
        return userService.resetPassword(userEmail);
    }



    @PostMapping("verifyOTP")
    private String verifyOTP(@RequestBody ResetDTO user) throws NoSuchAlgorithmException{
        return userService.verifyOTP(user);
    }
}
