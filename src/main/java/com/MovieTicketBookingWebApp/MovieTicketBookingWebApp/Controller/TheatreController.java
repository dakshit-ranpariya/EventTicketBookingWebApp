package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Controller;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Theatres;
import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service.TheatreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping("{id}")
    public Theatres getTheatresDetails(@PathVariable Integer id){
        return theatreService.getTheatresDetails(id);
    }



    @PostMapping("addTheatre")
    public List<Theatres> saveTheatres(@RequestBody List<Theatres> theatres){
        return theatreService.saveTheatres(theatres);
    }

}
