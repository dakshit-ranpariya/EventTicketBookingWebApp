package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Repository;

import com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    Admin findByAdminNameAndAdminPassword(String name, String password);

    Admin findByAdminName(String adminName);
}
