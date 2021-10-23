package RMS;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;




    public Guest(){
        this("", "", "", "");
    }

    public Guest (String lastName, String firstName){
        this(lastName, firstName, "","");
    }

    public Guest(String oneArgument, int type){
        this();
        switch (type){
            case 1: this.lastName = oneArgument;
                    this.firstName = oneArgument;
                    break;
            case 2: this.email = oneArgument;
                    break;
            case 3: this.phoneNumber = oneArgument;
                    break;
        }
    }

    public Guest(String lastName, String firstName, String email, String phoneNumber){
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

    public boolean equals(Object obj, int field){
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        switch(field){
            case 0:
                return (lastName.equals(((Guest) obj).getLastName()) && firstName.equals(((Guest) obj).getFirstName()));
            case 1:
                return (email.equals(((Guest) obj).getEmail()));
            case 2:
                return phoneNumber.equals(((Guest) obj).getPhoneNumber());
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

    public void updateGuest(String updatedTxt, int index){
        switch (index){
            case 1: this.lastName = updatedTxt;
                    System.out.println("Last name updated");
            break;
            case 2: this.firstName = updatedTxt;
                    System.out.println("First name updated");
            break;
            case 3: this.email = updatedTxt;
                    System.out.println("Email updated");
            break;
            case 4: this.phoneNumber = updatedTxt;
                    System.out.println("Phone number updated");
            break;
        }
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

    @Override
    public String toString(){
        return "Last Name: " + lastName + "\n" +
                "First Name: " + firstName +  "\n" +
                "Email: " + email + "\n" +
                "Phone number: " + phoneNumber;
    }
}
