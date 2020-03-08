package com.example.hotelreception.mail.pack.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@FeignClient("Reception")
public interface ReceptionistClient {
    @GetMapping("/isAcceptingPackage")
    boolean isAcceptingGuestPackages();
}
