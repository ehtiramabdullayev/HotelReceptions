package com.example.hotelreception.staying.services;

import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.common.CreateStayCommand;
import com.example.hotelreception.staying.channels.MySources;
import com.example.hotelreception.staying.models.Stay;
import com.example.hotelreception.staying.repositories.StayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @StreamListener(value = MySources.STAY_CREATE)
    private void mailPackageListener(CreateStayCommand createStayCommand) {
        if (createStayCommand != null) {
            Integer guestId = createStayCommand.getGuestId();
            Integer createdStay = createGuestStay(guestId);
            log.info("Stay number {} created ", createdStay);
        }
    }

    public List<Stay> getAllStaysHistory(){
        return stayRepository.findAll();
    }

    public Integer createGuestStay(Integer guestId) {
        Stay stay = new Stay();
        stay.setGuestId(guestId);
        Stay savedStay = stayRepository.save(stay);
        return savedStay.getId();
    }

    public StayRepository getStayRepository() {
        return stayRepository;
    }
}
