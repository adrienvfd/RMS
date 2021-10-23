package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.ArrayList;

public class WaitListCommand implements Command {

    ArrayList<Guest> waitList;

    WaitListCommand(GuestList guestList){
        this.waitList = guestList.getWaitingList();
    }

    @Override
    public void execute() {
        System.out.println("Guests on the wait list:");
        for (Guest guest : waitList){
            guest.toString();
        }
    }
}
