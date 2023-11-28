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
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public String registerUser(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public String signIn(@RequestBody String email, @RequestBody String Password) throws NoSuchAlgorithmException {
        return userService.signIn(email, Password);
    }

    @GetMapping("signout")
    public String signOut(@RequestBody String email){
        return userService.signoutUser(email);
    }

    @PostMapping("/resetPassword")
    private String resetPassword(@RequestParam String email){
        return userService.resetPassword(email);
    }

    @PostMapping("/verifyOTP")
    private String verifyOTP(@RequestBody ResetDTO user) throws NoSuchAlgorithmException{
        return userService.verifyOTP(user);
    }
}
