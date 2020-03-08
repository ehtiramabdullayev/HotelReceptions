package com.example.hotelreception.reception.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public interface MySources {
    String GUEST_PACKAGES = "guestPackageChannel";

    @Input(GUEST_PACKAGES)
    SubscribableChannel guestPackage();
}
