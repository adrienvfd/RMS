package RMS.commands;

import RMS.GuestList;

public class AvailableCommand implements Command{

    int availableSpots;

    AvailableCommand(GuestList guestList){
        this.availableSpots = guestList.getRemainingSpots();
    }


    @Override
    public void execute() {
        System.out.println("There are " + availableSpots + " available spots.");
    }
}
