package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.ArrayList;

public class WaitListCommand implements Command {

    private ArrayList<Guest> waitList;

    WaitListCommand(GuestList guestList){
        this.waitList = guestList.getWaitingList();
    }

    @Override
    public void execute() {

        if (waitList.size() == 0){
            System.out.println("The waiting list is empty");
        } else {
            System.out.println("Guests on the wait list:");
            for (Guest guest : waitList) {
                System.out.println(guest);
            }
        }
    }
}
