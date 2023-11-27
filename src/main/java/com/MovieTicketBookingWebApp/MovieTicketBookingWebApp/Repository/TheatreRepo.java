package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Theatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TheatreRepo extends JpaRepository<Theatres, Integer> {


}
