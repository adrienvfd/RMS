package RMS;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GuestList {

    private final int maxNumberParticipants;
    private ArrayList<Guest> guestList;
    private ArrayList<Guest> waitingList;

    public GuestList(int maxNumberParticipants) {
        this.maxNumberParticipants = maxNumberParticipants;
        this.guestList = new ArrayList<>(maxNumberParticipants);
        this.waitingList = new ArrayList<>();
    }

    public int addParticipant(Guest guest){
        if (isRegistered(guest)){
            return -1;
        }

        if (guestList.size() < maxNumberParticipants){
            guestList.add(guest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        }

        waitingList.add(guest);
        System.out.println("Te-ai inscris cu succes in lista de asteptare " +
                "si ai primit numarul de ordine "+ waitingList.size() +
                ". Te vom notifica daca un loc devine disponibil.");
        return waitingList.size();


    }
    public boolean isRegistered(Guest guest){
        return  guestList.stream().anyMatch(elt -> elt.equals(guest)) ||
                waitingList.stream().anyMatch(elt -> elt.equals(guest));
        // Note: equals has been overriden in Guest Class.
    }
    public boolean cancelRegistration(Guest guest){
        for (int i = 0; i < guestList.size(); i++){
            if (guest.equals(guestList.get(i))){
                guestList.remove(i);

                if (waitingList.size() != 0){
                    //add 1st person on waitingList to guestList
                    guestList.add(waitingList.get(1));
                    waitingList.remove(i);
                }
                System.out.println("persoana a fost stearsa cu succes");
                return true;
            }
        }

        for (int i = 0; i < waitingList.size(); i++){
            if (guest.equals(waitingList.get(i))){
                waitingList.remove(i);
                System.out.println("persoana a fost stearsa cu succes");
                return true;
            }
        }
        System.err.println("eroare: persoana nu era inscrisa");
        return false;
    }   // Punctul 3: ce se intelege prin (notificarea se face conform specificatiilor de mai sus
    public ArrayList<Guest> getGuestList() {
        return guestList;
    }
    public ArrayList<Guest> getWaitingList() {
        return waitingList;
    }
    public int getRemainingSpots(){
        return this.maxNumberParticipants - guestList.size();
    }
    public int getNumberOfParticipants(){
        return guestList.size();
    }
    public int getWaitingListNumberOfParticipants(){
        return waitingList.size();
    }
    public int getTotalNumberOfParticipantsOnLists(){
        return guestList.size() + waitingList.size();
    }

    public ArrayList<Guest> partialSearch(String str) {
        ArrayList<Guest> found = new ArrayList<>();
        found.addAll(guestList.stream()
                .filter(elt -> elt.contains(str))
                .collect(Collectors.toList()));
        found.addAll(waitingList.stream()
                .filter(elt -> elt.contains(str))
                .collect(Collectors.toList()));
        return found;
    }
}
