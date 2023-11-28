package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model.DTO;

import lombok.Data;

@Data
public class ResetDTO {
    String email;
    String otp;
    String newPass;
}
