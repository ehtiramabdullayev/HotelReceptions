package com.example.hotelreception.reception.services;

import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.reception.channels.MySources;
import com.example.hotelreception.reception.models.GuestPackage;
import com.example.hotelreception.reception.repositories.GuestPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class ReceptionistService {
    @Autowired
    private GuestPackageRepository guestPackageRepository;

    private boolean acceptGuestPackages;

    @StreamListener(value = MySources.GUEST_PACKAGES)
    private void guestPackageListener(CreatePackageCommand packageCommand) {
        if (packageCommand != null) {
            Integer guestId = packageCommand.getGuestId();
            Integer packageId = packageCommand.getPackageId();
            addGuestPackage(guestId, packageId);
        }
    }

    public Integer addGuestPackage(Integer guestId, Integer packageId) {
        GuestPackage guestPackage = new GuestPackage();
        guestPackage.setGuestId(guestId);
        guestPackage.setPackageId(packageId);
        GuestPackage savedGuestPackage = guestPackageRepository.save(guestPackage);
        final Integer savedPackageId = savedGuestPackage.getId();
        return savedPackageId;
    }

    public boolean acceptGuestPackages(int accept) {
        return acceptGuestPackages = accept == 1;
    }

    public boolean isAcceptGuestPackages() {
        return acceptGuestPackages;
    }
}
