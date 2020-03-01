package com.example.hotelreception.guest.repositories;

import com.example.hotelreception.guest.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {
}
