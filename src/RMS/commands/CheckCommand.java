package RMS.commands;

import RMS.GuestList;
import RMS.Guest;
import java.util.Scanner;

public class CheckCommand implements Command {

    public static final String [] ALLOWED_CHECK_OPTIONS = {"first or last name", "email", "phone number"};
    private GuestList guestList;
    private Guest guest;

    public CheckCommand(GuestList guestList, Scanner sc) {
        this.guestList = guestList;

        int type = userPromptType(sc);
        String info = userPromptInfo(sc, type);

        if (type != 1) {
            this.guest = new Guest(info, type);
        } else {
            String[] fullName = info.split(" ");
            if(fullName.length == 2) {
                this.guest = new Guest(fullName[0], fullName[1]);
            } else {
                System.err.println("Full name needs to have 1 first name & 1 last name");
                this.guest = null;
            }
        }
    }
    public CheckCommand(GuestList guestList, boolean fromChildren){
        this.guestList = guestList;
        this.guest = null;
    }

    protected int userPromptType(Scanner sc){
        int type;
        do {
            System.out.println("Choose what you want to detail: \n" +
                    "1 - last name & first name \n" +
                    "2 - email \n" +
                    "3 - phone number");
            type = sc.nextInt();
        } while (type < 0|| type > ALLOWED_CHECK_OPTIONS.length);
        return type;
    }
    private String userPromptInfo(Scanner sc, int type){
        System.out.println("Type " + ALLOWED_CHECK_OPTIONS[type -1] + "detail, then press Enter");
        String promptInfo = sc.nextLine();
        sc.next();
        return sc.nextLine();
    }

    protected String userPromptInfo(Scanner sc, int type, String[] ALLOWED){
        System.out.println("Type " + ALLOWED[type -1] + "detail, then press Enter");
        return sc.nextLine();
    }

    protected Guest getGuest() {
        return guest;
    }
    protected void setGuest(Guest guest) {
        this.guest = guest;
    }
    protected GuestList getGuestList() {
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
