package RMS.commands;

import RMS.Guest;
import RMS.GuestList;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchCommand implements Command {

    private String str;
    private ArrayList<Guest> foundList;

    SearchCommand(GuestList guestList, Scanner sc){
        System.out.println("Type who you are looking for");
        str = sc.next();
        this.foundList = guestList.partialSearch(str);
    }

    @Override
    public void execute() {
        System.out.println("Search Result(s): ");
        for (Guest foundGuest : foundList){
            System.out.println(foundGuest.toString());
            System.out.println("-------------");
        }
    }
}
