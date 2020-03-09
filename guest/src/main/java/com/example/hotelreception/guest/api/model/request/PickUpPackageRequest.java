package com.example.hotelreception.guest.api.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
public class PickUpPackageRequest {
    @NotNull
    @Positive
    private Integer guestId;

    public PickUpPackageRequest(@NotNull @Positive Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }
}
