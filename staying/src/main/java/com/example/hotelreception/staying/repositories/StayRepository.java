package com.example.hotelreception.staying.repositories;

import com.example.hotelreception.staying.models.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public interface StayRepository extends JpaRepository<Stay, Integer> {
    List<Stay> getStayByGuestIdAndCheckedOutAtIsNull(Integer integer);
}
