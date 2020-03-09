package com.example.hotelreception.staying.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
@Entity
@DynamicUpdate
@Table(name = "stays")
public class Stay extends BasicEntity {
    @Column(name = "guest_id")
    private Integer guestId;

    @Column(updatable = false)
    private LocalDate checkedInAt;

    @Column(updatable = false)
    private LocalDate checkedOutAt;

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
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
