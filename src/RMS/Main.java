package RMS;

import RMS.commands.Helper;
import RMS.commands.Navigator;

import java.util.Scanner;

public class Main {

    /*

     */



    public static void main(String[] args) {
        GuestList myGuestList = new GuestList(10);
        Scanner sc = new Scanner(System.in);
        String str;
        Helper.printHelper();
        boolean quit = false;

        while (!quit) {
            str = sc.next();
            quit = Navigator.navigate(myGuestList, str, sc);
        }
    }
}
