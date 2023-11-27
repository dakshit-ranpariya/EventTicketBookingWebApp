package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Theatres;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository.TheatreRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TheatreService {

    @Autowired
    TheatreRepo theatreRepo;

    public Theatres getTheatresDetails(Integer id) {
        return theatreRepo.findById(id).orElse(null);
    }

    public List<Theatres> saveTheatres(List<Theatres> theatres) {
        return theatreRepo.saveAll(theatres);
    }



}
