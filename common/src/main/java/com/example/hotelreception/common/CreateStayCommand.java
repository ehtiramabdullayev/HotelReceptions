package com.example.hotelreception.common;

/**
 * @author Ehtiram_Abdullayev on 3/9/2020
 * @project hotel-reception
 */
public class CreateStayCommand extends AbstractPackageCommand {
    public CreateStayCommand() {
    }

    public CreateStayCommand(Integer guestId) {
        super(guestId);
    }

}
