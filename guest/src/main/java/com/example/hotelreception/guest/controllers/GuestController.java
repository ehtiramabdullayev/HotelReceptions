package com.example.hotelreception.guest.controllers;

import com.example.hotelreception.guest.api.model.response.GuestResponse;
import com.example.hotelreception.guest.models.BasicEntity;
import com.example.hotelreception.guest.models.Guest;
import com.example.hotelreception.guest.service.GuestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/guests")
    public List<GuestResponse> getGuestList() {
        List<Guest> list = guestService.list();

        return list
                .stream()
                .map(GuestResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/guestsIds")
//    @HystrixCommand
    public List<Integer> getGuestListIds() {
//        List<Guest> list = guestService.list();

        List<Guest> list = new ArrayList<>();
        Guest guest = new Guest();
        guest.setId(1);

        Guest guest2 = new Guest();
        guest2.setId(2);

        Guest guest3 = new Guest();
        guest3.setId(3);

        Guest guest4 = new Guest();
        guest4.setId(4);

        list.add(guest);
        list.add(guest2);
        list.add(guest3);
        list.add(guest4);

        return list
                .stream()
                .map(BasicEntity::getId)
                .collect(Collectors.toList());
    }

}
