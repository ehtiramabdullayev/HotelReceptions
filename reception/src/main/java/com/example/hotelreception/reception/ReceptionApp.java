package com.example.hotelreception.reception;

import com.example.hotelreception.reception.channels.MySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MySources.class)
@EnableFeignClients
public class ReceptionApp {
    public static void main(String[] args) {
        SpringApplication.run(ReceptionApp.class, args);
    }
}
