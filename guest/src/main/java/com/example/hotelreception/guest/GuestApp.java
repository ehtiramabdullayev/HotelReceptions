package com.example.hotelreception.guest;

import com.example.hotelreception.guest.channel.MySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Ehtiram_Abdullayev on 2/29/2020
 * @project hotel-reception
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding(MySources.class)
public class GuestApp {
    public static void main(String[] args) {
        SpringApplication.run(GuestApp.class, args);
    }

}
