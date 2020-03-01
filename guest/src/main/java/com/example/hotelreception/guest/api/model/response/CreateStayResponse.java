package com.example.hotelreception.guest.api.model.response;

/**
 * @author Ehtiram_Abdullayev on 3/1/2020
 * @project hotel-reception
 */
public class CreateStayResponse {
    private int id;

    public CreateStayResponse(int id) {
        this.id = id;
    }

    public CreateStayResponse() {
    }

    public int getId() {
        return id;
    }
}
