package com.example.hotelreception.mail.pack;

import com.example.hotelreception.mail.pack.channel.MyChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableHystrix
@EnableBinding(MyChannels.class)
public class MailPackageApp {
    public static void main(String[] args) {
        SpringApplication.run(MailPackageApp.class, args);
    }

}
