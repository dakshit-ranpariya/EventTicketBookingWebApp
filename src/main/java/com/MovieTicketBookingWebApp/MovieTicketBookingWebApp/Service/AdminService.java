package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Admin;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;


    public String adminLogin(String name, String password) {
        if(name.equals("admin")&&password.equals("admin")){
            Admin admin = adminRepo.findByAdminNameAndAdminPassword(name,password);
            admin.setStatus("Logged In");
            adminRepo.save(admin);
            return "Admin Logged In Successfully";
        }
        return "Ok";
    }
}
