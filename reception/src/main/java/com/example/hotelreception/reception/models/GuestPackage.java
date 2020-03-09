package com.example.hotelreception.reception.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
@Entity
@DynamicUpdate
@Table(name = "guestPackage")
public class GuestPackage extends BasicEntity{

    @Column(name = "guest_id")
    private Integer guestId;

    @Column(name = "package_id")
    private Integer packageId;

    @Column
    private String description;

    @Column
    private LocalDate packageTakenAt;

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public LocalDate getPackageTakenAt() {
        return packageTakenAt;
    }

    public void setPackageTakenAt(LocalDate packageTakenAt) {
        this.packageTakenAt = packageTakenAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestPackage that = (GuestPackage) o;
        return Objects.equals(guestId, that.guestId) &&
                Objects.equals(packageId, that.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, packageId);
    }

    @Override
    public String toString() {
        return "GuestPackage{" +
                "guestId=" + guestId +
                ", packageId=" + packageId +
                '}';
    }
}
