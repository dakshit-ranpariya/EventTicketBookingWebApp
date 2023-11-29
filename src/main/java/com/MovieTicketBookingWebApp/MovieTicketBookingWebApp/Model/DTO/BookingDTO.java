package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.DTO;

import lombok.Data;

@Data
public class BookingDTO {
    private String userEmail;
    private String showName;
    private String classType;
    private Integer tickets;
}
