package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Admin;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Shows;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.AdminRepo;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    AdminRepo adminRepo;
    public String addShow(Shows show) {
        Admin admin = adminRepo.findByAdminName("admin");
        if(admin.getStatus().equals("Logged In")){
            showRepo.save(show);
            return "Show Added Successfully";
        }else{
            return "Admin Login Required!";
        }
    }

    public String removeShow(String showName) {
        Admin admin = adminRepo.findByAdminName("admin");
        if(admin.getStatus().equals("Logged In")){
            if(!showRepo.existsByShowName(showName)){
                return "Show Not Found";
            }
            Shows show = showRepo.findByShowName(showName);
            showRepo.delete(show);
            return "Show deleted Successfully";
        }else{
            return "Admin Login Required!";
        }
    }
}
