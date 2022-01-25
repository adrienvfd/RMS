package RMS.commands;

import RMS.GuestList;

public class ResetCommand implements Command{

    private GuestList gl;

    ResetCommand(GuestList gl){
        this.gl = gl;
    }
    @Override
    public void execute() {
        gl.resetGuestList();
    }
}
