package com.example.hotelreception.common;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public class CreateCheckoutCommand extends AbstractPackageCommand {
    public CreateCheckoutCommand(Integer guestId) {
        super(guestId);
    }
}
