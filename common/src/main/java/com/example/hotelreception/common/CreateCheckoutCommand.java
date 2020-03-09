package com.example.hotelreception.common;

/**
 * @author Ehtiram_Abdullayev on 3/8/2020
 * @project hotel-reception
 */
public class CreateCheckoutCommand extends AbstractPackageCommand {
    private boolean checkPackages;

    public CreateCheckoutCommand(Integer guestId, boolean checkPackages) {
        super(guestId);
        this.checkPackages = checkPackages;
    }

    public boolean isCheckPackages() {
        return checkPackages;
    }
}
