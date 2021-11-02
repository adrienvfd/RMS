package RMS.commands;

import RMS.GuestList;

public class WaitListNbCommand implements Command {

    private int waitListNb;

    WaitListNbCommand(GuestList guestList){ this.waitListNb = guestList.getWaitingListNumberOfParticipants(); }

    @Override
    public void execute() {
        System.out.println("There are " + waitListNb + " people on the waiting list.");
    }
}
