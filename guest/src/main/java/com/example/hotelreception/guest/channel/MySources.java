package com.example.hotelreception.guest.channel;

import org.springframework.messaging.MessageChannel;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public interface MySources {
    MessageChannel stay();
}
