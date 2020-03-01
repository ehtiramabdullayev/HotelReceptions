package com.example.hotelreception.guest.controllers;

import com.example.hotelreception.guest.api.model.response.GuestResponse;
import com.example.hotelreception.guest.models.Guest;
import com.example.hotelreception.guest.service.GuestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@RestController
@RequestMapping(value = "/guest")
public class GuestController {
    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GuestResponse> getGuestList() {
        List<Guest> list = guestService.list();

        return list
                .stream()
                .map(GuestResponse::new)
                .collect(Collectors.toList());
    }

}
