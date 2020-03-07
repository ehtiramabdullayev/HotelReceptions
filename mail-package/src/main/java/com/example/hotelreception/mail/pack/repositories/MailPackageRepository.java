package com.example.hotelreception.mail.pack.repositories;

import com.example.hotelreception.mail.pack.models.MailPackage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
public interface MailPackageRepository extends JpaRepository<MailPackage,Integer> {
}
