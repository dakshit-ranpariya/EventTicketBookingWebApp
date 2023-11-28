package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.DTO.ResetDTO;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.UserRepo;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.Utility.OTPGenerator;
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
            user.setStatus(("Logged Out"));
            userRepo.save(user);
            return "Logout Sucessfully";
        }else {
            return "Already LogOut";
        }
    }

    public String resetPassword(String email) {
        if(!userRepo.existsByuserEmail((email))){
            return "User Not Register";
        }
        User user = userRepo.findByUserEmail(email);
        String otp = OTPGenerator.generateOTP();

        user.setOtp(otp);
        userRepo.save(user);
        EmailService.sendOtpEmail(email,otp);
        return "OTP Send Successfully";
    }

    public String verifyOTP(ResetDTO user) throws NoSuchAlgorithmException {
        User existingUser =userRepo.findByUserEmail(user.getEmail());
        if(existingUser != null && existingUser.getOtp().equals(user.getOtp())){
            String newHashPass = passwordEncrypter.hashPasswordWithStaticSecret(user.getNewPass());
            existingUser.setUserPassword(newHashPass);
            userRepo.save(existingUser);
            return "Password Changed";
        }else{
            return "Invalid OTP";
        }

    }

}
