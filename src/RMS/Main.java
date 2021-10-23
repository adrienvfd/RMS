package RMS;
import RMS.commands.Navigator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuestList myGuestList = new GuestList(2);
        Scanner sc = new Scanner(System.in);
        String str = "helper";
        boolean quit = false;

        // start the app!
        while (!quit) {
            quit = Navigator.navigate(myGuestList, str, sc);

            str = sc.next();
        }
        sc.close();
    }
}
