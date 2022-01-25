package RMS.commands;

import RMS.GuestList;
import java.util.Scanner;

public class Navigator {

    public static boolean navigate(GuestList guestList, String str, Scanner sc){
        Command cmd = null;
        if (str.equals("help")){
            cmd = (Command) new HelperCommand();
        } else if (str.equals("add")) {
            cmd = (Command) new AddCommand(guestList, sc);
        } else if (str.equals("check")){
            cmd = (Command) new CheckCommand(guestList, sc);
        } else if (str.equals("remove")){
            cmd = (Command) new RemoveCommand(guestList, sc);
        } else if (str.equals("update")) {
            cmd = (Command) new UpdateCommand(guestList, sc);
        } else if (str.equals("guests")){
            cmd = (Command) new GuestsCommand(guestList);
        } else if (str.equals("waitlist")){
            cmd = (Command) new WaitListCommand(guestList);
        } else if (str.equals("available")){
            cmd = (Command) new AvailableCommand(guestList);

        } else if (str.equals("guests_no")){
            cmd = (Command) new GuestNbCommand(guestList);
        } else if (str.equals("waitlist_no")){
            cmd = (Command) new WaitListNbCommand(guestList);
        } else if (str.equals("subscribe_no")){
            cmd = (Command) new SubscribeNbCommand(guestList);
        } else if (str.equals("search")) {
            cmd = (Command) new SearchCommand(guestList, sc);
        } else if (str.equals("reset")){
            cmd = (Command) new ResetCommand(guestList);
        } else if (str.equals("quit")){
            System.out.println("Closing application...");
            return true;
        } else {
            System.out.println("Type \"help\" to show the help menu");;
        }

        if (cmd != null){
            cmd.execute();

            if (cmd instanceof ResetCommand) return true;
        }

        return false;
    }
}
