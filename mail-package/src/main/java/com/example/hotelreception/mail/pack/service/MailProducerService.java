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

    private GuestClient guestClient;

    private ReceptionistClient receptionistClient;

    private MailPackageRepository mailPackageRepository;

    private MyChannels channels;

    public MailProducerService(GuestClient guestClient, ReceptionistClient receptionistClient,
                               MailPackageRepository mailPackageRepository, MyChannels channels) {
        this.guestClient = guestClient;
        this.receptionistClient = receptionistClient;
        this.mailPackageRepository = mailPackageRepository;
        this.channels = channels;
    }

    public List<Integer> getIds() {
        List<Integer> integers = guestClient.getGuestListIds();
        System.out.println(integers);
        return integers;
    }

    public void sendPackage(Integer guestId, String description) {
        if (!receptionistClient.isAcceptingGuestPackages()) {
            throw new IllegalArgumentException("Isnt accepting guest packages");
        }
        MailPackage mailPackage = new MailPackage();
        mailPackage.setDescription(description);
        MailPackage savedPackage = mailPackageRepository.save(mailPackage);

        channels.guest().send(MessageBuilder.withPayload(
                new CreatePackageCommand(guestId, savedPackage.getId(), description)).build()
        );
    }

    public void test(String name) {
        if (receptionistClient.isAcceptingGuestPackages()) {
            channels.guest().send(MessageBuilder.withPayload(
                    new CreatePackageCommand(1, 2, "a")).build());
        } else {
            throw new IllegalArgumentException("Isnt accepting guest packages");
        }

    }
}
