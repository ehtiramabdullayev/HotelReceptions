package com.example.hotelreception.common;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
public class CheckoutStayCommand extends AbstractPackageCommand {
    public CheckoutStayCommand() {
    }

    public CheckoutStayCommand(Integer guestId) {
        super(guestId);
    }
}
