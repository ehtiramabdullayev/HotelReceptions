package com.example.hotelreception.common;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
public class CreateCheckinCommand extends AbstractPackageCommand {
    public CreateCheckinCommand() {
    }

    public CreateCheckinCommand(Integer guestId) {
        super(guestId);
    }
}
