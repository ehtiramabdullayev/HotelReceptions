package com.example.hotelreception.staying;

import com.example.hotelreception.staying.channels.MySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding(MySources.class)
public class StayingApp {
    public static void main(String[] args) {
        SpringApplication.run(StayingApp.class, args);
    }

}
