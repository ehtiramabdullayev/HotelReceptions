package com.example.hotelreception.staying.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
public interface MySources {
    String STAY_CREATE = "guestCreateStayChannel";

    @Input(STAY_CREATE)
    SubscribableChannel createStay();
}
