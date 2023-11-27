package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
