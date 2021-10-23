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
            System.out.println("This user is already registered");
            return -1;
        }

        if (guestList.size() < maxNumberParticipants){
            guestList.add(guest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        } else{
            //add on waiting list
            waitingList.add(guest);
            System.out.println("Te-ai inscris cu succes in lista de asteptare " +
                    "si ai primit numarul de ordine "+ waitingList.size() +
                    ". Te vom notifica daca un loc devine disponibil.");
            return waitingList.size();
        }
    }
    public boolean isRegistered(Guest guest){
        return  guestList.stream().anyMatch(crtGuest -> crtGuest.equals(guest)) ||
                waitingList.stream().anyMatch(crtGuest -> crtGuest.equals(guest));
        // Note: equals has been overriden in Guest Class.
    }
    public boolean remove(Guest guest){
        for (int i = 0; i < guestList.size(); i++){
            if (guest.equals(guestList.get(i))){
                guestList.remove(i);

                if (waitingList.size() != 0){
                    //add 1st person on waitingList to guestList
                    guestList.add(waitingList.get(0));
                    waitingList.remove(0);
                }
                System.out.println("persoana " + guest.getFirstName() + " " + guest.getLastName() + " a fost stearsa cu succes");
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
    public Guest findGuest(Guest guest){
        for (Guest crtGuest : guestList){
            if (crtGuest.equals(guest)){
                return guest;
            }
        }
        for (Guest crtGuest : waitingList){
            if (crtGuest.equals(guest)){
                return guest;
            }
        }
        return null;
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
