package RMS;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;


    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            /*  2 guests are considered equal if:
            - lastName && firstName are the same,
            - Or if they have the same email
            - Or if they have the same phone Number */
        if (lastName.equals(((Guest) obj).lastName) && firstName.equals(((Guest) obj).firstName)
                || email.equals(((Guest) obj).email)
                || phoneNumber.equals(((Guest) obj).phoneNumber)) {
            return true;
        }
        return false;
    }


    public boolean contains(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if( lastName.contains(str)  ||
            firstName.contains(str) ||
            email.contains(str)     ||
            phoneNumber.contains(str)){
            return true;
        }
        return false;
    }
}
