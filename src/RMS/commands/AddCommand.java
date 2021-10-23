package RMS.commands;
import RMS.Guest;
import RMS.GuestList;

import java.util.Scanner;

public class AddCommand {
    private GuestList guestList;
    private Guest newGuest;

    public AddCommand(GuestList guestList, Scanner sc){
        this.guestList = guestList;
        String[] userData = promptUser(sc);
        newGuest = new Guest(userData[0], userData[1], userData[2], userData[3]);
    }

    private String[] promptUser(Scanner sc){
        String[] userData = new String[4];
        System.out.println("Let's add a new user...");
        System.out.println("What's your first name ?");
        userData[0] = sc.next();
        System.out.println("What's your last name?");
        userData[1] = sc.next();
        System.out.println("What's your email address?");
        userData[2] = sc.next();
        System.out.println("What's your phone number ?");
        userData[3] = sc.next();
        return userData;
    }

    public void execute(){
        guestList.addParticipant(newGuest);
    }




}
