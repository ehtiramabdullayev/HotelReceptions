package com.example.hotelreception.mail.pack.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
@Entity
@DynamicUpdate
@Table(name = "packages")
public class MailPackage extends BasicEntity {
    @NotBlank
    @Column
    private String description;

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
        MailPackage that = (MailPackage) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "MailPackage{" +
                "description='" + description + '\'' +
                '}';
    }
}
