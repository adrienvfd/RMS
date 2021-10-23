package RMS.commands;

import RMS.GuestList;

public class SubscribeNbCommand implements Command {
    private int subscribeNb;

    SubscribeNbCommand(GuestList guestList){
        this.subscribeNb = guestList.getTotalNumberOfParticipantsOnLists();
    }

    @Override
    public void execute() {
        System.out.println("There are " + subscribeNb + " people on all lists");
    }
}
