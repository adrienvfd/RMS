package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.Scanner;

public class UpdateCommand extends CheckCommand implements Command {

    public static final String [] ALLOWED_UPDATE_OPTIONS = {"first name", "last name", "email", "phone number"};
    public String newText;

    public UpdateCommand(GuestList guestList, Scanner sc){
        super(guestList, true);

        // What field am I looking for
        int fieldToLookFor = userPromptType(sc);

        // Prompt an info about the user we're looking for:
        String lookingFor = userPromptInfo(sc, fieldToLookFor);

        //Create a guest in parent class
        // Does the user exist ?
       if (guestList.isRegistered(super.getGuest())){
           Guest guest = new Guest(lookingFor, fieldToLookFor);
           int indexToUpdate = userPromptType(sc);
           String updatedField = userPromptInfo(sc, indexToUpdate, ALLOWED_UPDATE_OPTIONS);
           //UPDATE:
           guest = super.getGuestList().findGuest(guest);
           guest.updateGuest(updatedField, indexToUpdate);
       }

        // Set guest:


        newText = userPromptInfo(sc, fieldToLookFor);
    }

    protected Guest lookForGuest(String lookingFor, int fieldToLookFor){
        for (Guest guest : getGuestList().findGuest(){

        }
    }



    @Override
    public int userPromptType (Scanner sc){
        System.out.println("Who do you want to update? Pick the detail: ");
        return super.userPromptType(sc);
    }

    public String userPromptInfo(Scanner sc, int type){
        System.out.println("Type in new data: ");
        return super.userPromptInfo(sc, type, ALLOWED_UPDATE_OPTIONS);
    }

    @Override
    public void execute(){
        Guest guestToUpdate = super.getGuestList().findGuest(super.getGuest());
        guestToUpdate.updateGuest(newText, fieldToLookFor);
    }
}
