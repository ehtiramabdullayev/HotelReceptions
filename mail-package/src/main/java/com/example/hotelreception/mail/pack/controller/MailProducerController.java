package com.example.hotelreception.mail.pack.controller;

import com.example.hotelreception.mail.pack.service.MailProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/6/2020
 * @project hotel-reception
 */
@RestController
public class MailProducerController {

    @Autowired
    private MailProducerService mailProducerService;

    @GetMapping("/guestIds")
    public List<Integer> getGuestIds() {
        return mailProducerService.getIds();
    }

    @GetMapping("/test/{name}")
    public void publish(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        mailProducerService.test(greeting);
    }

}
