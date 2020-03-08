package com.example.hotelreception.reception.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@FeignClient("Guest")
public interface GuestClient {
    @GetMapping("/guestCheckouts")
    List<Integer> getGuestCheckOuts();
}
