package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.Scanner;

public class RemoveCommand extends CheckCommand implements Command {

    RemoveCommand(GuestList guestList, Scanner sc){
        super(guestList, sc);
    }

    @Override
    public void execute(){
        super.getGuestList().remove(super.getGuest());
    }
}
