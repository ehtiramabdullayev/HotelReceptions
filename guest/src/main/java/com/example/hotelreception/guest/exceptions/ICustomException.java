package com.example.hotelreception.guest.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public interface ICustomException {
    HttpStatus getStatus();
}
