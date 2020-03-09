package com.example.hotelreception.mail.pack.producer;

import com.example.hotelreception.mail.pack.service.MailProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
@Component
public class PackageProducerScheduler {
    private static Logger logger = LoggerFactory.getLogger(PackageProducerScheduler.class);

    private MailProducerService mailProducerService;

    public PackageProducerScheduler(MailProducerService mailProducerService) {
        this.mailProducerService = mailProducerService;
    }

    @Scheduled(cron = "0 0 */1 * * *")
    public void sendPackagesToUsersRandomly() {
        logger.info("Method sendPackagesToUsersRandomly started");
        try {
            for(Integer id :mailProducerService.getIds()){
                mailProducerService.sendPackage(id,"Description "+ UUID.randomUUID());
            }
        } catch (Exception e) {
            logger.error("Exception happened while sendPackagesToUsersRandomly: ", e);
        }
        logger.info("Method sendPackagesToUsersRandomly ended");
    }
}
