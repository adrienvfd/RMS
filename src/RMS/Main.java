package RMS;
import RMS.commands.Navigator;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    private static final long serialVersionUID = 1L;


    public static void main(String[] args) throws IOException {

        GuestList myGuestList;

        try{
            myGuestList = GuestList.readFromBinaryFile();
        } catch (Exception e){
            myGuestList = null;
        }

        Scanner sc = new Scanner(System.in);

        // New GuestList or
        if (myGuestList == null) {
            System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
            myGuestList = new GuestList(sc.nextInt());
        }

        // Launch app
        String str = "helper";
        boolean quit = false;
        while (true) {
            quit = Navigator.navigate(myGuestList, str, sc);
            if(quit) break;
            str = sc.next();
        }
        sc.close();
        // IF reset hasn't been activated, save changes:
        if (!myGuestList.getResetGuestList()){
            GuestList.writeToBinaryFile(myGuestList);
        }

    }
}
