package com.example.hotelreception.reception.controllers;

import com.example.hotelreception.reception.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@RestController
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    @GetMapping("/acceptPackages/{acceptOrNot}")
    public void setAcceptOrNot(@PathVariable Integer acceptOrNot) {
        String greeting = "Hello, " + acceptOrNot + "!";
        receptionistService.acceptGuestPackages(acceptOrNot);
        System.out.println(acceptOrNot);
    }

    @GetMapping("/isAcceptingPackage")
    boolean isAcceptingGuestPackages() {
        return receptionistService.isAcceptGuestPackages();
    }

    @GetMapping("/guestStays")
    List<Integer> getGuestStays() {
        return receptionistService.getGuestStays();
    }
}
