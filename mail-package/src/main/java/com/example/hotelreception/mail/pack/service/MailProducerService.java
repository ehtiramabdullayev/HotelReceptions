package com.example.hotelreception.mail.pack.service;

import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.mail.pack.channel.MyChannels;
import com.example.hotelreception.mail.pack.client.GuestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/6/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class MailProducerService {

    @Autowired
    private GuestClient guestClient;


    @Autowired
    private MyChannels channels;

    public List<Integer> getIds() {
        List<Integer> integers = guestClient.getGuestListIds();
        System.out.println(integers);
        return integers;
    }

    public void sendPackage(Integer packageId) {
        int guestId = 1;
        channels.guestPackage().send(MessageBuilder.withPayload(
                new CreatePackageCommand(guestId, packageId)).build()
        );
    }
}
