package com.example.hotelreception.mail.pack.service;

import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.mail.pack.channel.MyChannels;
import com.example.hotelreception.mail.pack.client.GuestClient;
import com.example.hotelreception.mail.pack.client.ReceptionistClient;
import com.example.hotelreception.mail.pack.models.MailPackage;
import com.example.hotelreception.mail.pack.repositories.MailPackageRepository;
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
    private ReceptionistClient receptionistClient;

    @Autowired
    private MailPackageRepository mailPackageRepository;

    @Autowired
    private MyChannels channels;

    public List<Integer> getIds() {
        List<Integer> integers = guestClient.getGuestListIds();
        System.out.println(integers);
        return integers;
    }

    public void sendPackage(Integer guestId) {
        if (!receptionistClient.isAcceptingGuestPackages()) {
            throw new IllegalArgumentException("Isnt accepting guest packages");
        }
        MailPackage mailPackage = new MailPackage();
        mailPackage.setDescription("ssasas");
        MailPackage savedPackage = mailPackageRepository.save(mailPackage);

        Integer savedPackageId = savedPackage.getId();
        channels.guestPackage().send(MessageBuilder.withPayload(
                new CreatePackageCommand(guestId, savedPackageId)).build()
        );
    }

    public void test(String name) {
        if (receptionistClient.isAcceptingGuestPackages()) {
            channels.guestPackage().send(MessageBuilder.withPayload(
                    new CreatePackageCommand(1, 2)).build());
        } else {
            throw new IllegalArgumentException("Isnt accepting guest packages");
        }

    }
}
