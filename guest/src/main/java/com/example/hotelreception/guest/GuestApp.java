package com.example.hotelreception.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Ehtiram_Abdullayev on 2/29/2020
 * @project hotel-reception
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GuestApp {
    public static void main(String[] args) {
        SpringApplication.run(GuestApp.class, args);
    }

}
