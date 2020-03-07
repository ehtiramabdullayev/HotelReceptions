package com.example.hotelreception.mail.pack.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
public interface MyChannels {
    @Output
    MessageChannel guestPackage();

}
