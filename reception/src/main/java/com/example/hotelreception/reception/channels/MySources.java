package com.example.hotelreception.reception.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public interface MySources {
    String MAIL_PACKAGES = "guestPackageChannel";
    String GUEST = "";

    @Input(MAIL_PACKAGES)
    SubscribableChannel mailPackage();

    @Input(GUEST)
    SubscribableChannel guest();
}
