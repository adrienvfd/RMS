package RMS;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;




    public Guest(){
        this("", "", "", "");
    }

    public Guest(String oneArgument, int type){
        this();
        switch (type){
            case 0: this.lastName = oneArgument;
                    this.firstName = oneArgument;
                    break;
            case 1: this.email = oneArgument;
                    break;
            case 2: this.phoneNumber = oneArgument;
                    break;
        }
    }

    public Guest(String firstName, String lastName, String email, String phoneNumber){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            /*  2 guests are considered equal if:
            - lastName && firstName are the same,
            - Or if they have the same email
            - Or if they have the same phone Number */
        return (lastName.equals(((Guest) obj).getLastName()) && firstName.equals(((Guest) obj).getFirstName())
                || email.equals(((Guest) obj).getEmail())
                || phoneNumber.equals(((Guest) obj).getPhoneNumber()));
    }

    public boolean check(Object obj, int field){
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        switch(field){
            case 0:
                return (lastName.equals(((Guest) obj).getLastName()) && firstName.equals(((Guest) obj).getFirstName()));
                break;
            case 1:
                return (email.equals(((Guest) obj).getEmail()));
                break;
            case 2:
                return phoneNumber.equals(((Guest) obj).getPhoneNumber());
                break;
            default: return false;
        }
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

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
