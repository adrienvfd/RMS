package RMS.exceptions;

public class EmailFormatException extends RuntimeException {
    public EmailFormatException(){
        super("Email Format incorrect");
    }
    public EmailFormatException(String message){
        super(message);
    }
}
