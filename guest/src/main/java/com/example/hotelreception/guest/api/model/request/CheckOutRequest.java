package com.example.hotelreception.guest.api.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public class CheckOutRequest {
    @NotNull
    @Positive
    private Integer guestId;


    public CheckOutRequest(@NotNull @Positive Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getGuestId() {
        return guestId;
    }

}
