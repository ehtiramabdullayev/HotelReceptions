package com.example.hotelreception.staying.services;

import com.example.hotelreception.common.AbstractPackageCommand;
import com.example.hotelreception.common.CheckoutStayCommand;
import com.example.hotelreception.common.CreateCheckinCommand;
import com.example.hotelreception.common.CreateStayCommand;
import org.springframework.cloud.stream.messaging.Sink;
import com.example.hotelreception.staying.models.Stay;
import com.example.hotelreception.staying.repositories.StayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
@Service
public class StayService {
    private static final Logger log = LoggerFactory.getLogger(StayService.class);

    private StayRepository stayRepository;

    public StayService(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }

    @StreamListener(value = Sink.INPUT)
    private void streamListener(AbstractPackageCommand abstractPackageCommand) {
        if (abstractPackageCommand instanceof CreateStayCommand) {

            CreateStayCommand createStayCommand = (CreateStayCommand) abstractPackageCommand;
            Integer guestId = createStayCommand.getGuestId();
            Integer createdStay = createGuestStay(guestId);
            log.info("Stay number {} created ", createdStay);

        } else if (abstractPackageCommand instanceof CheckoutStayCommand) {

            CheckoutStayCommand checkoutStayCommand = (CheckoutStayCommand) abstractPackageCommand;
            Integer guestId = checkoutStayCommand.getGuestId();
            Integer checkedOutStay = checkOutGuestStay(guestId);
            log.info("Stay number {} checked out ", checkedOutStay);

        } else if (abstractPackageCommand instanceof CreateCheckinCommand) {

            CreateCheckinCommand checkoutStayCommand = (CreateCheckinCommand) abstractPackageCommand;
            Integer guestId = checkoutStayCommand.getGuestId();
            Integer checkedOutStay = checkInGuestStay(guestId);
            log.info("Stay number {} checked in ", checkedOutStay);

        }
    }

    public List<Stay> getAllStaysHistory() {
        return stayRepository.findAll();
    }

    public Integer createGuestStay(Integer guestId) {
        boolean isGuestAlreadyStaying = stayRepository.
                getStayByGuestIdAndCheckedOutAtIsNull(guestId).size() == 1;

        if (isGuestAlreadyStaying) {
            throw new RuntimeException("Guest Already staying");
        }
        Stay stay = new Stay();
        stay.setGuestId(guestId);
        Stay savedStay = stayRepository.save(stay);
        return savedStay.getId();
    }

    public Integer checkOutGuestStay(Integer guestId) {
        List<Stay> guestStays = stayRepository.
                getStayByGuestIdAndCheckedOutAtIsNullAndCheckedInAtIsNotNull(guestId);
        Integer stayId = 0;
        boolean isGuestAlreadyStaying = guestStays.size() == 1;
        if (isGuestAlreadyStaying) {
            Stay stay = guestStays.get(0);
            stay.setCheckedOutAt(LocalDate.now());
            Stay savedStay = stayRepository.save(stay);
            stayId = savedStay.getId();
        } else {
            throw new RuntimeException("There is not guest to checkout");
        }
        return stayId;
    }

    public Integer checkInGuestStay(Integer guestId) {
        List<Stay> guestStays = stayRepository.
                getStayByGuestIdAndCheckedOutAtIsNullAndCheckedInAtIsNull(guestId);
        Integer stayId = 0;
        boolean isGuestAlreadyStaying = guestStays.size() == 1;
        if (isGuestAlreadyStaying) {
            Stay stay = guestStays.get(0);
            stay.setCheckedInAt(LocalDate.now());
            Stay savedStay = stayRepository.save(stay);
            stayId = savedStay.getId();


        } else {
            throw new RuntimeException("There is not guest to checkout");
        }
        return stayId;
    }


    public StayRepository getStayRepository() {
        return stayRepository;
    }
}
