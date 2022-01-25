package RMS;

import java.io.*;
import java.util.List;

public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;


    public Guest() {
        this("", "", "", "");
    }

    public Guest(String oneArgument, int type) {
        this();
        switch (type) {
            case 1:
                this.lastName = oneArgument;
                this.firstName = oneArgument;
                break;
            case 2:
                this.email = oneArgument;
                break;
            case 3:
                this.phoneNumber = oneArgument;
                break;
        }
    }

    public Guest(String lastName, String firstName) {
        this(lastName, firstName, "", "");
    }

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
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
        return (lastName.toLowerCase().equals(((Guest) obj).getLastName().toLowerCase()) && firstName.toLowerCase().equals(((Guest) obj).getFirstName().toLowerCase())
                || email.toLowerCase().equals(((Guest) obj).getEmail().toLowerCase())
                || phoneNumber.toLowerCase().equals(((Guest) obj).getPhoneNumber().toLowerCase()));
    }

    public boolean contains(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (lastName.toLowerCase().contains(str) ||
                firstName.toLowerCase().contains(str) ||
                email.toLowerCase().contains(str) ||
                phoneNumber.toLowerCase().contains(str)) {
            return true;
        }
        return false;
    }

    public void updateGuest(String updatedTxt, int index) {
        switch (index) {
            case 1:
                this.lastName = updatedTxt;
                System.out.println("Last name updated");
                break;
            case 2:
                this.firstName = updatedTxt;
                System.out.println("First name updated");
                break;
            case 3:
                this.email = updatedTxt;
                System.out.println("Email updated");
                break;
            case 4:
                this.phoneNumber = updatedTxt;
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
    public String toString() {
        return "Last Name: " + lastName + "\n" +
                "First Name: " + firstName + "\n" +
                "Email: " + email + "\n" +
                "Phone number: " + phoneNumber;
    }

 /*   public static void writeToBinaryFile(List<Guest> data) throws IOException {
        try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("guest.dat")))) {
            binaryFileOut.writeObject(data);
        }
    }

    public static List<Guest> readFromBinaryFile() throws IOException {
        List<Guest> data = null;

        try (ObjectInputStream binaryFileIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("guest.dat")))) {
            data = (List<Guest>) binaryFileIn.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
        }
        return data;
    }

  */
}
