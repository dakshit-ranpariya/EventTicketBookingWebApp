package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    private String userPassword;

    private String userDob;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    @Column(unique = true)
    private String userEmail;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String userMobileNo;

    private String status;

    private String otp;

}
