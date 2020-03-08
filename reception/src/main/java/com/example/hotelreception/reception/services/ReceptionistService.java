package com.example.hotelreception.reception.services;

import com.example.hotelreception.common.CreateCheckoutCommand;
import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.reception.channels.MySources;
import com.example.hotelreception.reception.client.GuestClient;
import com.example.hotelreception.reception.models.GuestPackage;
import com.example.hotelreception.reception.repositories.GuestPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class ReceptionistService {
    @Autowired
    private GuestPackageRepository guestPackageRepository;

    @Autowired
    private GuestClient guestClient;

    private boolean acceptGuestPackages;

    @StreamListener(value = MySources.MAIL_PACKAGES)
    private void mailPackageListener(CreatePackageCommand packageCommand) {
        if (packageCommand != null) {
            Integer guestId = packageCommand.getGuestId();
            Integer packageId = packageCommand.getPackageId();
            addGuestPackage(guestId, packageId);
        }
    }

    @StreamListener(value = MySources.GUEST)
    private void guestListener(CreateCheckoutCommand checkoutCommand) {
        if(checkoutCommand!=null){

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

    public List<Integer> getGuestStays() {
        return guestClient.getGuestCheckOuts();
    }


    public boolean acceptGuestPackages(int accept) {
        return acceptGuestPackages = accept == 1;
    }

    public boolean isAcceptGuestPackages() {
        return acceptGuestPackages;
    }
}
