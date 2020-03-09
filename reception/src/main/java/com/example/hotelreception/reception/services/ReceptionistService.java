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
import java.util.stream.Collectors;


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
    private void mailPackageListener(CreatePackageCommand<GuestPackage> packageCommand) {
        if (packageCommand != null) {
            Integer guestId = packageCommand.getGuestId();
            Integer packageId = packageCommand.getPackageId();
            String description = packageCommand.getPackageDescription();
            addGuestPackage(guestId, packageId, description);
        }
    }

    @StreamListener(value = MySources.GUEST_CHECKOUT)
    private void guestCheckOutListener(CreateCheckoutCommand checkoutCommand) {
        if (checkoutCommand != null) {
            Integer guestId = checkoutCommand.getGuestId();
            if (!getAllNonTakenPackagesOfTheGuest(guestId).isEmpty() && checkoutCommand.isCheckPackages()){

            }
        }
    }

    public Integer addGuestPackage(Integer guestId, Integer packageId, String description) {
        GuestPackage guestPackage = new GuestPackage();
        guestPackage.setGuestId(guestId);
        guestPackage.setPackageId(packageId);
        guestPackage.setDescription(description);
        GuestPackage savedGuestPackage = guestPackageRepository.save(guestPackage);
        final Integer savedPackageId = savedGuestPackage.getId();
        return savedPackageId;
    }

    public void giveGuestsPackages() {

    }

    public List<GuestPackage> getAllGuestPackages() {
        return guestPackageRepository.findAll();
    }

    public List<GuestPackage> getAllNonTakenPackagesOfTheGuest(Integer guestId) {
        return guestPackageRepository.findAllByGuestId(guestId).stream().
                filter(guestPackage -> guestPackage.getPackageTakenAt() == null).
                collect(Collectors.toList());
    }


    public List<Integer> getGuestStays() {
        return guestClient.getGuestCheckOuts();
    }


    public void acceptGuestPackages(int accept) {
        acceptGuestPackages = accept == 1;
    }

    public boolean isAcceptGuestPackages() {
        return acceptGuestPackages;
    }
}
