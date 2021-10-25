package RMS;
import RMS.commands.Navigator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        GuestList myGuestList = new GuestList(sc.nextInt());

        // Launch app
        String str = "helper";
        boolean quit = false;

        while (true) {
            quit = Navigator.navigate(myGuestList, str, sc);
            if (quit){
                break;
            }
            str = sc.next();
            }
        sc.close();
    }
}
