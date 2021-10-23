package RMS;

import RMS.commands.AddCommand;
import RMS.commands.Command;


import java.util.Scanner;

public class Helper {
    /*
        help         - Afiseaza aceasta lista de comenzi
        add          - Adauga o noua persoana (inscriere)
        check        - Verifica daca o persoana este inscrisa la eveniment
        remove       - Sterge o persoana existenta din lista
        update       - Actualizeaza detaliile unei persoane
        guests       - Lista de persoane care participa la eveniment
        waitlist     - Persoanele din lista de asteptare
        available    - Numarul de locuri libere
        guests_no    - Numarul de persoane care participa la eveniment
        waitlist_no  - Numarul de persoane din lista de asteptare
        subscribe_no - Numarul total de persoane inscrise
        search       - Cauta toti invitatii conform sirului de caractere introdus
        quit         - Inchide aplicatia
     */

    public static void navigate(GuestList guestList, String str, Scanner sc){
        Command cmd = null;
        if (str.equals("help")){
            printHelper();
        } else if (str.equals("add")) {
                cmd = (Command) new AddCommand(guestList, sc);
        }

        if (cmd != null){
            cmd.execute();
        }
    }

    public static void printHelper(){
        System.out.println(
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
        );
    }
}
