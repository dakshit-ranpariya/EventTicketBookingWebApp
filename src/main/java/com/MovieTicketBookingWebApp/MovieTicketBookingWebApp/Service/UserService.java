package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.UserRepo;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.Utility.passwordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String registerUser(User user) throws NoSuchAlgorithmException {
            if(userRepo.existsByuserEmail(user.getUserEmail())){
                return "User Already Registerd";
            }
            String hashPass = passwordEncrypter.hashPasswordWithStaticSecret(user.getUserPassword());
            user.setUserPassword(hashPass);
            userRepo.save(user);
            return "Register Successfully";
    }


    public String signIn(String email, String password) throws NoSuchAlgorithmException {
        if(!userRepo.existsByuserEmail(email)){
            return "Please Register";
        }
        String hashPass = passwordEncrypter.hashPasswordWithStaticSecret(password);
        User user =userRepo.findByUserEmail(email);
        if(hashPass.equals(user.getUserPassword())){
            user.setStatus("Logged In");
            userRepo.save(user);
            return "Login Successfully";
        }else{
            return "Invalid Credentials";
        }
    }

    public String signoutUser(String email) {
        User user =userRepo.findByUserEmail(email);

        if(user.getStatus().equals("Logged in")){
            user.setStatus(("Log Out"));
            userRepo.save(user);
            return "Logout Suceessfully";
        }else {
            return "Already LogOut";
        }
    }
}
