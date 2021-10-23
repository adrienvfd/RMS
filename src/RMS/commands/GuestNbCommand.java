package RMS.commands;

import RMS.GuestList;

public class GuestNbCommand implements Command {
    int guestNb;

    GuestNbCommand(GuestList guestList){
        this.guestNb = guestList.getNumberOfParticipants();
    }

    @Override
    public void execute() {
        System.out.println("There are " + guestNb + "participants.");
    }
}
