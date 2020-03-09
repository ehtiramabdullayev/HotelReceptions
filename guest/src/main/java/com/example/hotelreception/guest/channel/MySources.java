package com.example.hotelreception.guest.channel;

import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public interface MySources {

    @Output("guestCheckOutChannel")
    MessageChannel checkOut();

    @Output("guestCreateStayChannel")
    MessageChannel createStay();
}
