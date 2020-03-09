package com.example.hotelreception.reception.repositories;

import com.example.hotelreception.reception.models.GuestPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public interface GuestPackageRepository extends JpaRepository<GuestPackage, Integer> {

    List<GuestPackage> findAllByGuestId(Integer guestId);
}
