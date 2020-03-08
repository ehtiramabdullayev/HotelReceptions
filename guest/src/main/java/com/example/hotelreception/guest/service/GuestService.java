package com.example.hotelreception.guest.service;

import com.example.hotelreception.common.CreateCheckoutCommand;
import com.example.hotelreception.guest.api.model.request.CheckInRequest;
import com.example.hotelreception.guest.api.model.request.CheckOutRequest;
import com.example.hotelreception.guest.api.model.request.CreateStayRequest;
import com.example.hotelreception.guest.channel.MySources;
import com.example.hotelreception.guest.exceptions.NotFoundException;
import com.example.hotelreception.guest.models.Guest;
import com.example.hotelreception.guest.models.Stay;
import com.example.hotelreception.guest.repositories.GuestRepository;
import com.example.hotelreception.guest.repositories.StayRepository;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class GuestService {
    private final GuestRepository guestRepository;
    private final StayRepository stayRepository;
    private final MySources mySources;

    public GuestService(GuestRepository guestRepository,
                        StayRepository stayRepository,
                        MySources mySources) {
        this.guestRepository = guestRepository;
        this.stayRepository = stayRepository;
        this.mySources = mySources;
    }

    public List<Guest> list() {
        return guestRepository.findAll();
    }

    public List<Stay> listGuestCheckOuts() {
        return stayRepository.findAll();
    }

    public Integer planStayCheckInAndCheckOut(CreateStayRequest createStayRequest) {
        Guest guest = guestRepository.findById(createStayRequest.getGuestId())
                .orElseThrow(() -> new NotFoundException("Guest does not exist !"));
        Stay guestStay = new Stay();
        guestStay.setGuest(guest);
        guestStay.setPlannedCheckInDate(createStayRequest.getPlannedCheckInDate());
        guestStay.setPlannedCheckOutDate(createStayRequest.getPlannedCheckOutDate());

        Stay createdStay = stayRepository.save(guestStay);
        return createdStay.getId();
    }

    public Integer checkIn(CheckInRequest checkInRequest) {
        Stay stay = stayRepository.getStayByGuestId(checkInRequest.getGuestId())
                .orElseThrow(() -> new NotFoundException("Guest didn't plan any stay yet!"));
        stay.setPlannedCheckInDate(LocalDate.now());
        Stay createdStay = stayRepository.save(stay);
        return createdStay.getId();
    }

    public Integer checkOut(CheckOutRequest checkOutRequest) {
        Stay stay = stayRepository.getStayByGuestId(checkOutRequest.getGuestId())
                .orElseThrow(() -> new NotFoundException("Guest didn't plan any stay yet!"));
        stay.setPlannedCheckOutDate(LocalDate.now());
        Stay createdStay = stayRepository.save(stay);

        mySources.checkOut().send(MessageBuilder.withPayload(
                new CreateCheckoutCommand(createdStay.getGuest().getId())).build()
        );
        return createdStay.getId();
    }

}
