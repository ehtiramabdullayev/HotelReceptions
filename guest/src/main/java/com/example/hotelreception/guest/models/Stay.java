package com.example.hotelreception.guest.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@Entity
@DynamicUpdate
@Table(name = "stays")
public class Stay extends BasicEntity {
    @ManyToOne
    private Guest guest;

    @Column(updatable = false)
    private LocalDate plannedCheckInDate;

    @Column(updatable = false)
    private LocalDate plannedCheckOutDate;

    @Column(updatable = false)
    private LocalDate checkedInAt;

    @Column(updatable = false)
    private LocalDate checkedOutAt;

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getPlannedCheckInDate() {
        return plannedCheckInDate;
    }

    public void setPlannedCheckInDate(LocalDate plannedCheckInDate) {
        this.plannedCheckInDate = plannedCheckInDate;
    }

    public LocalDate getPlannedCheckOutDate() {
        return plannedCheckOutDate;
    }

    public void setPlannedCheckOutDate(LocalDate plannedCheckOutDate) {
        this.plannedCheckOutDate = plannedCheckOutDate;
    }

    public LocalDate getCheckedInAt() {
        return checkedInAt;
    }

    public void setCheckedInAt(LocalDate checkedInAt) {
        this.checkedInAt = checkedInAt;
    }

    public LocalDate getCheckedOutAt() {
        return checkedOutAt;
    }

    public void setCheckedOutAt(LocalDate checkedOutAt) {
        this.checkedOutAt = checkedOutAt;
    }
}
