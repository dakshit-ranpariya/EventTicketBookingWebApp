package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("login")
    public String adminLogin(@RequestParam String adminName, @RequestParam String adminPassword){
        return adminService.adminLogin(adminName, adminPassword);
    }

    @PostMapping("logout")
    public String adminLogout(@RequestParam String adminName){
        return adminService.adminLogout(adminName);
    }

}
