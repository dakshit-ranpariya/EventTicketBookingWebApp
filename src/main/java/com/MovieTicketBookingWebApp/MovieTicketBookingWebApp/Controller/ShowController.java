package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;


import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.DTO.BookingDTO;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Shows;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("addShow")
    private String addShow(@RequestBody Shows show){
        return showService.addShow(show);
    }

    @GetMapping("allShows")
    private List<Shows> getAllShows(){
        return showService.getAllShows();
    }

    @PostMapping("removeShow")
    private String removeShow(@RequestParam String showName){
        return showService.removeShow(showName);
    }


    @PostMapping("book")
    private String ticketBooking(@RequestBody BookingDTO bookingDTO){
        return showService.ticketBooking(bookingDTO);
    }
}
