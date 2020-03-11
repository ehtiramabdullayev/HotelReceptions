package com.example.hotelreception.guest.service;

import com.example.hotelreception.common.CheckoutStayCommand;
import com.example.hotelreception.common.CreateCheckinCommand;
import com.example.hotelreception.common.CreateStayCommand;
import com.example.hotelreception.guest.api.model.request.PickUpPackageRequest;
import com.example.hotelreception.guest.channel.MySources;
import com.example.hotelreception.guest.models.Guest;
import com.example.hotelreception.guest.repositories.GuestRepository;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class GuestService {
    private final GuestRepository guestRepository;
    private final MySources mySources;

    public GuestService(GuestRepository guestRepository, MySources mySources) {
        this.guestRepository = guestRepository;
        this.mySources = mySources;
    }

    public List<Guest> list() {
        return guestRepository.findAll();
    }

    public int createStay(Integer guestId) {
        if (guestRepository.existsById(guestId)) {
            mySources.stay().send(MessageBuilder.withPayload(
                    new CreateStayCommand(guestId)).build()
            );
        } else {
            throw new RuntimeException("Guest hasn't found !");
        }
        return guestId;
    }

    public int checkOutStay(Integer guestId) {
        if (guestRepository.existsById(guestId)) {
            mySources.stay().send(MessageBuilder.withPayload(
                    new CheckoutStayCommand(guestId)).build()
            );
        } else {
            throw new RuntimeException("Guest hasn't found !");
        }
        return guestId;
    }


    public int checkInStay(Integer guestId) {
        if (guestRepository.existsById(guestId)) {
            mySources.stay().send(MessageBuilder.withPayload(
                    new CreateCheckinCommand(guestId)).build()
            );
        } else {
            throw new RuntimeException("Guest hasn't found !");
        }
        return guestId;
    }


//    public List<Stay> listGuestCheckOuts() {
//        return stayRepository.findAll();
//    }

//    public Integer planStayCheckInAndCheckOut(CreateStayRequest createStayRequest) {
//        Guest guest = guestRepository.findById(createStayRequest.getGuestId())
//                .orElseThrow(() -> new NotFoundException("Guest does not exist !"));
//        Stay guestStay = new Stay();
//        guestStay.setGuest(guest);
//        guestStay.setPlannedCheckInDate(createStayRequest.getPlannedCheckInDate());
//        guestStay.setPlannedCheckOutDate(createStayRequest.getPlannedCheckOutDate());
//
//        Stay createdStay = stayRepository.save(guestStay);
//        return createdStay.getId();
//    }

//    public Integer checkIn(CheckInRequest checkInRequest) {
//        Stay stay = stayRepository.getStayByGuestId(checkInRequest.getGuestId())
//                .orElseThrow(() -> new NotFoundException("Guest didn't plan any stay yet!"));
//        stay.setPlannedCheckInDate(LocalDate.now());
//        Stay createdStay = stayRepository.save(stay);
//        return createdStay.getId();
//    }

//    public Integer checkOut(CheckOutRequest checkOutRequest) {
//        Stay stay = stayRepository.getStayByGuestId(checkOutRequest.getGuestId())
//                .orElseThrow(() -> new NotFoundException("Guest didn't plan any stay yet!"));
//        stay.setPlannedCheckOutDate(LocalDate.now());
//        Stay createdStay = stayRepository.save(stay);
//
//        mySources.checkOut().send(MessageBuilder.withPayload(
//                new CreateCheckoutCommand(createdStay.getGuest().getId(),
//                                          checkOutRequest.isCheckPackages())).build()
//        );
//        return createdStay.getId();
//    }


    public Integer pickupPackage(PickUpPackageRequest pickUpPackageRequest) {
        return 0;
    }
}
