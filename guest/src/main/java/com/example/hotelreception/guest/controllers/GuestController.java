package com.example.hotelreception.guest.controllers;

import com.example.hotelreception.guest.api.model.request.PickUpPackageRequest;
import com.example.hotelreception.guest.api.model.response.GuestResponse;
import com.example.hotelreception.guest.models.BasicEntity;
import com.example.hotelreception.guest.models.Guest;
import com.example.hotelreception.guest.service.GuestService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public List<GuestResponse> getGuestList() {
        List<Guest> list = guestService.list();

        return list
                .stream()
                .map(GuestResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/createStay")
    public Integer createStay(Integer guestId) {
       return guestService.createStay(guestId);
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


//    @GetMapping("/guestCheckouts")
//    public List<Integer> getGuestCheckOuts() {
//        List<Stay> guestCheckOuts = guestService.listGuestCheckOuts();
//
//        return guestCheckOuts
//                .stream()
//                .map(BasicEntity::getId)
//                .collect(Collectors.toList());
//    }

//    @PutMapping("/checkout")
//    public Integer checkOut(CheckOutRequest checkOutRequest) {
//        Integer checkOutId = guestService.checkOut(checkOutRequest);
//        return checkOutId;
//    }

    @PutMapping("/pickUp")
    public Integer pickUpPackage(PickUpPackageRequest pickUpPackageRequest) {
        Integer checkOutId = guestService.pickupPackage(pickUpPackageRequest);
        return checkOutId;
    }
}
