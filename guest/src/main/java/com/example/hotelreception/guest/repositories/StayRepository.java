package com.example.hotelreception.guest.repositories;

import com.example.hotelreception.guest.models.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public interface StayRepository extends JpaRepository<Stay,Integer> {
}
