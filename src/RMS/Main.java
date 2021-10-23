package RMS;

import java.util.Scanner;

public class Main {

    /*

     */



    public static void main(String[] args) {
        GuestList myGuestList = new GuestList(10);
        Scanner sc = new Scanner(System.in);
        String str;
        Helper.printHelper();

        do {
             str = sc.next();
            Helper.navigate(myGuestList, str, sc);
        }while (!str.equals("exit"));
    }
}
