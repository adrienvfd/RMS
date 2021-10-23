package RMS.commands;

import RMS.GuestList;



import java.util.Scanner;

public class Helper implements Command {
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
                        "quit         - Inchide aplicatia" + "\n" +
                        "--------------- \n" +
                        "What are you looking for?"
        );
    }
    public void execute(){
        printHelper();
    }


}
