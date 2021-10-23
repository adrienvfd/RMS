package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.Scanner;

public class UpdateCommand extends CheckCommand implements Command {

    public static final String [] ALLOWED_UPDATE_OPTIONS = {"first name", "last name", "email", "phone number"};
    public int fieldToUpdate;
    public String newText;

    public UpdateCommand(GuestList guestList, Scanner sc){
        super(guestList, true);

        fieldToUpdate = userPromptType(sc);
        newText = userPromptInfo(sc, fieldToUpdate);
    }


    @Override
    public int userPromptType (Scanner sc){
        System.out.println("Who do you want to update? ");
        return super.userPromptType(sc);
    }


    public String userPromptInfo(Scanner sc, int type){
        System.out.println("Type in new data: ");
        return super.userPromptInfo(sc, type, ALLOWED_UPDATE_OPTIONS);
    }

    @Override
    public void execute(){
        Guest guestToUpdate = super.getGuestList().findGuest(super.getGuest());
        guestToUpdate.updateGuest(newText, fieldToUpdate);
    }
}
