package RMS.commands;

import RMS.GuestList;

public class WaitListNb implements Command {

    private int waitListNb;

    WaitListNb(GuestList guestList){ this.waitListNb = guestList.getWaitingListNumberOfParticipants(); }

    @Override
    public void execute() {
        System.out.println("There are " + waitListNb + " people on the waiting list.");
    }
}
