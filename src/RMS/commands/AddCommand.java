package RMS.commands;
import RMS.Guest;
import RMS.GuestList;
import RMS.exceptions.EmailFormatException;
import RMS.exceptions.PhoneFormatException;

import java.util.Scanner;


public class AddCommand implements Command{
    private GuestList guestList;
    private Guest newGuest;
    String[] userData;

    public AddCommand(GuestList guestList, Scanner sc){
        this.guestList = guestList;
        this.userData = new String[4];
        promptUser(userData, sc);
        newGuest = new Guest(userData[0], userData[1], userData[2], userData[3]);
    }

    private void promptUser(String[] userData, Scanner sc){
        System.out.println("Let's add a new user...");

        // Prompt Last Name
        System.out.println("What's your last name ?");
        userData[0] = sc.next();

        // Prompt First Name
        System.out.println("What's your first name?");
        userData[1] = sc.next();

        // Prompt Email
        while (true) {
            System.out.println("What's your email address?");
            try {
                userData[2] = sc.next();
                if (!userData[2].contains("@")) throw new EmailFormatException();
                break;
            } catch (EmailFormatException e) {
                System.err.println("Error Email must contain '@' ");
            }
        }

        // Prompt Phone Number
        while (true){
            System.out.println("What's your phone number ?");
            try{
                userData[3] = sc.next();
                if (userData[3].length() != 10) throw new PhoneFormatException();
                for (int i = 0; i < userData[3].length(); i++){
                    if (!Character.isDigit(userData[3].charAt(i))) throw new PhoneFormatException();
                }
                break;
            } catch (PhoneFormatException e){
                System.err.println("Error, Phone number must contain 10 digits");
            }
        }
    }

    public void execute(){
        guestList.addParticipant(newGuest);
    }

}
