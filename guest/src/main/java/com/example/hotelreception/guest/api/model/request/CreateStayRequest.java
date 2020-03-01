package com.example.hotelreception.guest.api.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public class CreateStayRequest {
    @NotNull
    @Positive
    private Integer guestId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate plannedCheckInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate plannedCheckOutDate;

    public CreateStayRequest(Integer guestId,
                             LocalDate plannedCheckInDate,
                             LocalDate plannedCheckOutDate) {
        this.guestId = guestId;
        this.plannedCheckInDate = plannedCheckInDate;
        this.plannedCheckOutDate = plannedCheckOutDate;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public LocalDate getPlannedCheckInDate() {
        return plannedCheckInDate;
    }

    public LocalDate getPlannedCheckOutDate() {
        return plannedCheckOutDate;
    }

}
