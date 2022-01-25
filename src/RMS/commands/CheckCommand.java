package RMS.commands;

import RMS.GuestList;
import RMS.Guest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckCommand implements Command {

    private static final String [] ALLOWED_CHECK_OPTIONS = {"last name and first name", "email", "phone number"};
    private GuestList guestList;
    private Guest guest;

    CheckCommand(GuestList guestList, Scanner sc) {
        this.guestList = guestList;

        // What type of data are we gonna look for
        int type;
        type = userPromptType(sc);


        // What data are we looking for:
        String info = userPromptInfo(sc, type);

        if (type != 1) {
            this.guest = new Guest(info, type);
        } else {
            String[] fullName;
            fullName = info.split(" ");
            if(fullName.length == 2) {
                this.guest = new Guest(fullName[0], fullName[1]);
            } else {
                System.err.println("Full name needs to have 1 last name & 1 first name");
                this.guest = null;
            }
        }
    }
    CheckCommand(GuestList guestList, boolean fromChildren){
        this.guestList = guestList;
        this.guest = null;
    }

    int userPromptType(Scanner sc) {
        int type = -1;
        while (true) {
            try {
                System.out.println("How do you want to find the person?: \n" +
                        "1 - last name & first name \n" +
                        "2 - email \n" +
                        "3 - phone number");
                type = sc.nextInt();
                sc.nextLine();

                if (type <= 0 || type > ALLOWED_CHECK_OPTIONS.length) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error, you have to write a number between 1 - 3");
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error, this was not a number!!!");
                sc.nextLine();
            }
        }
        return type;
    }
    String userPromptInfo(Scanner sc, int type){
        System.out.println("Type " + ALLOWED_CHECK_OPTIONS[type -1] + " detail, then press Enter");
        return sc.nextLine();
    }
    String userPromptInfo(Scanner sc, int type, String[] ALLOWED){
        System.out.println("Type " + ALLOWED[type -1] + " detail, then press Enter");
        return sc.nextLine();
    }


    Guest getGuest() {
        return guest;
    }
    GuestList getGuestList() {
        return guestList;
    }

    public void execute(){
        if(guestList.isRegistered(guest)) {
            System.out.println("This user is registered");
        } else{
            System.out.println("This user is not registered");
        }
    }
}
