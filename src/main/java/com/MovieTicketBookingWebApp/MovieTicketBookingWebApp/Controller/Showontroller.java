package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;


import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Shows;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class Showontroller {

    @Autowired
    ShowService showService;

    @PostMapping("addShow")
    private String addShow(@RequestBody Shows show){
        return showService.addShow(show);
    }
}
