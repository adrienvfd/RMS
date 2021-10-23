package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.ArrayList;

public class Guests implements Command{

    ArrayList<Guest> allGuests;

    Guests(GuestList guestList){
        this.allGuests = new ArrayList<>();
        this.allGuests.addAll(guestList.getGuestList());
        this.allGuests.addAll(guestList.getWaitingList());
    }

    @Override
    public void execute() {
        System.out.println("List of all registered (including waiting list): ");
        for (Guest guest : allGuests){
            System.out.println(guest);
            System.out.println("---------------");
        }
    }
}
