package com.example.hotelreception.guest.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @CreationTimestamp
    private LocalDateTime plannedCheckInDate;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime plannedCheckOutDate;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime checkedInAt;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime checkedOutAt;

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setPlannedCheckInDate(LocalDateTime plannedCheckInDate) {
        this.plannedCheckInDate = plannedCheckInDate;
    }

    public void setPlannedCheckOutDate(LocalDateTime plannedCheckOutDate) {
        this.plannedCheckOutDate = plannedCheckOutDate;
    }

    public void setCheckedInAt(LocalDateTime checkedInAt) {
        this.checkedInAt = checkedInAt;
    }

    public void setCheckedOutAt(LocalDateTime checkedOutAt) {
        this.checkedOutAt = checkedOutAt;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDateTime getPlannedCheckInDate() {
        return plannedCheckInDate;
    }

    public LocalDateTime getPlannedCheckOutDate() {
        return plannedCheckOutDate;
    }

    public LocalDateTime getCheckedInAt() {
        return checkedInAt;
    }

    public LocalDateTime getCheckedOutAt() {
        return checkedOutAt;
    }
}
