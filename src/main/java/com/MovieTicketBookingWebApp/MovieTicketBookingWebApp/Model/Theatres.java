package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "theatres")
@AllArgsConstructor
@NoArgsConstructor
public class Theatres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String theatreName;
    private String theatreAddress;
    private String theatreSeats;
}
