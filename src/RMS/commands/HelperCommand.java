package RMS.commands;

public class HelperCommand implements Command {
    public static void printHelper(){
        System.out.println(
                        "--------------- \n" +
                        "help           - Display the command list \n" +
                        "add            - Add a new participant (register) \n" +
                        "check          - Check if a person is participating \n" +
                        "remove         - Remove a person from the list \n" +
                        "update         - Update the details of a participant \n" +
                        "guests         - List of the participants \n" +
                        "waitlist       - List of the people on the waiting list \n" +
                        "available      - Number of available spots on the main list \n" +
                        "guests_no      - Number of participants in the main list \n" +
                        "waitlist_no    - Number of people on the waiting list \n" +
                        "subscribe_no   - Number total of people on main list AND waiting list \n" +
                        "search         - Search a person in all the lists from using a string. \n" +
                        "reset          - Reset and exit app \n" +
                        "quit           - Exit the app \n" +
                        "--------------- \n"
        );
    }
    public void execute(){
        printHelper();
    }
}
