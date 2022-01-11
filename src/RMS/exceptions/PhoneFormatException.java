package RMS.exceptions;

public class PhoneFormatException extends RuntimeException {
    public PhoneFormatException(){
        super("Phone format incorrect");
    }

    public PhoneFormatException(String message){
        super(message);
    }
}
