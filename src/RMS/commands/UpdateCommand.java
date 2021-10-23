package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.Scanner;

public class UpdateCommand extends CheckCommand implements Command {

    private static final String [] ALLOWED_UPDATE_OPTIONS = {"first name", "last name", "email", "phone number"};
    private String newText;
    private int indexToUpdate;
    private Guest guestToModify;

    UpdateCommand(GuestList guestList, Scanner sc){
        super(guestList, true);
        // What field am I looking for
        int fieldToLookFor = userPromptType(sc);
        // Prompt an info about the user we're looking for:
        String lookingFor = userPromptInfo(sc, fieldToLookFor);

        // Creating a new Guest with attributes we're looking for;
        this.guestToModify = new Guest(lookingFor, fieldToLookFor);

        // Does the user exist ?
       if (guestList.isRegistered(guestToModify)){
           // This new guest needs to becom a "real" geast from the list --->
           this.guestToModify = super.getGuestList().findGuest(guestToModify);
           // Prompt for new type of modification:
           this.indexToUpdate = userPromptTypeToUpdate(sc);
           // Prompt for new modification
           this.newText = userPromptInfo(sc, indexToUpdate, ALLOWED_UPDATE_OPTIONS);


       }
    }

    int userPromptTypeToUpdate (Scanner sc){
        System.out.println("What do you want to update? ");
            int type;
            for (int i = 1; i <= ALLOWED_UPDATE_OPTIONS.length; i++) {
                System.out.println(i + "- " + ALLOWED_UPDATE_OPTIONS[i - 1]);
            }
            do {
                System.out.println("Type Number between " + 1 + " and " + ALLOWED_UPDATE_OPTIONS.length);
                type = sc.nextInt();
            } while (type < 0|| type > ALLOWED_UPDATE_OPTIONS.length);
            return type;
    }
    protected String userPromptInfo(Scanner sc, int type, String[] ALLOWED){
        System.out.println("Type in new data: ");
        return super.userPromptInfo(sc, type, ALLOWED);
    }

    @Override
    public void execute(){
        if (guestToModify == null){
            System.err.println("Error, this guest does not exist");
        } else{
            guestToModify.updateGuest(newText, indexToUpdate);
            System.out.println("Successful update");
        }

    }
}
