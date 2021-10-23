package RMS.commands;

import RMS.GuestList;
import RMS.Guest;
import java.util.Scanner;

public class CheckCommand implements Command {
    public static String [][] ALLOWED_OPTIONS = {{"firstName, lastName"}, {"email"}, {"phoneNumber"}};

    private GuestList guestList;
    private Guest guest;

    /*
    check:
            utilizatorul va fi invitat initial sa aleaga optiunea dupa care se face cautarea:
            lastName si firstName
            email
            phoneNumber
            ulterior, in functie de criteriul ales, se va introduce sirul / sirurile de caracter specifice cautarii

    */
    public void CheckCommand(GuestList guestList, Scanner sc) {
        this.guestList = guestList;

        int type = userPromptType(sc);
        String info = userPromptInfo(sc, type);

        this.guest = new Guest(info, type);
    }

    private int userPromptType(Scanner sc){
        int type;
        do {
            System.out.println("Choose what you want to find: \n" +
                    "1 - last name & first name \n" +
                    "2 - email \n" +
                    "3 - phone number");
            type = sc.nextInt();
        } while (type < 0|| type > ALLOWED_OPTIONS.length);
        return type;
    }
    private String userPromptInfo(Scanner sc, int type){
        System.out.println("Write down the " + ALLOWED_OPTIONS[type -1] + " you are looking for, then press Enter");
        return sc.next();

    }


    public void execute(){
        guestList.isRegistered(guest);
    }
}
