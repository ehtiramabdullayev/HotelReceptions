package com.example.hotelreception.reception.services;

import com.example.hotelreception.common.AbstractPackageCommand;
import com.example.hotelreception.common.CreatePackageCommand;
import com.example.hotelreception.reception.channels.MySources;
import com.example.hotelreception.reception.repositories.GuestPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.cloud.stream.annotation.StreamListener;


/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@Service
@Transactional
public class ReceptionistService {
    @Autowired
    private GuestPackageRepository guestPackageRepository;

    @StreamListener(MySources.GUEST_PACKAGES)
    private void guestPackageListener(CreatePackageCommand packageCommand) {
        if (packageCommand != null) {
//            createOrder(
//                    orderCommand.getTableId(),
//                    ((CreateOrderCommand) orderCommand).getMenuItems()
//            );
            System.out.println(
                    ((CreatePackageCommand)packageCommand ).getPackageId()
            );
        }
    }
}
