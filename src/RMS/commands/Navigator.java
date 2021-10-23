package RMS.commands;

import RMS.GuestList;

import java.util.Scanner;

public class Navigator {
    /*
                            "help         - Afiseaza aceasta lista de comenzi\n" +
                        "add          - Adauga o noua persoana (inscriere)\n" +
                        "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                        "remove       - Sterge o persoana existenta din lista\n" +
                        "update       - Actualizeaza detaliile unei persoane\n" +
                        "guests       - Lista de persoane care participa la eveniment\n" +
                        "waitlist     - Persoanele din lista de asteptare\n" +
                        "available    - Numarul de locuri libere\n" +
                        "guests_no    - Numarul de persoane care participa la eveniment\n" +
                        "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                        "subscribe_no - Numarul total de persoane inscrise\n" +
                        "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                        "quit         - Inchide aplicatia"

     */
    public static boolean navigate(GuestList guestList, String str, Scanner sc){
        Command cmd = null;
        if (str.equals("help")){
            cmd = (Command) new Helper();
        } else if (str.equals("add")) {
            cmd = (Command) new AddCommand(guestList, sc);
        } else if (str.equals("check")){
            cmd = (Command) new CheckCommand(guestList, sc);
        } else if (str.equals("remove")){
            cmd = (Command) new RemoveCommand(guestList, sc);
        } else if (str.equals("update")) {
            cmd = (Command) new UpdateCommand(guestList, sc);
        } else if (str.equals("guests")){
            cmd = (Command) new Guests(guestList);
        } else if (str.equals("waitlist")){
            cmd = (Command) new WaitListCommand(guestList);
        } else if (str.equals("available")){
            cmd = (Command) new AvailableCommand(guestList);

        } else if (str.equals("guests_no")){
            cmd = (Command) new GuestNbCommand(guestList);
        } else if (str.equals("waitlist_no")){
            cmd = (Command) new WaitListNb(guestList);
        } else if (str.equals("subscribe_no")){
            cmd = (Command) new SubscribeNbCommand(guestList);
        } else if (str.equals("search")){
            cmd = (Command) new SearchCommand(guestList, sc);
        } else if (str.equals("quit")){
            return true;
        } else {
            cmd = (Command) new Helper();
        }

        if (cmd != null){
            cmd.execute();
        }
        return false;

    }
}
