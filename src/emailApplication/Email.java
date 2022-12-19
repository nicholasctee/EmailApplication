package emailApplication;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 10000;
    private int defaultPasswordLength = 9;
    private String companySuffix = "doubleurizz.edu";

    // left private because we don't want people to access these. we will use encapsulation to access this info through class APIs...

    //This will be the constructor to receive the first and last name
    public Email(String firstName, String lastName) { //constructor definition here
        this.firstName = firstName;
        this.lastName = lastName; //this keyword refers to the class level variable and not the local one.

        // We want to call a method asking and returning a department.
        this.department = setDepartment();

        //We want to also call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your new password is: " + this.password);

        //We ALSO want to call a method that combines all the elements to generate an email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // This will ask user for their department.
    private String setDepartment () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nice to meet you, " + firstName + " " + lastName + "! " + "Please choose the number that corresponds to your department: \n1 for IT\n2 for Software Engineering\n3 for Human Resources\nEnter department code: ");
        int departmentChoice = Integer.valueOf(scanner.nextInt());
        if (departmentChoice == 1) {
            return "it";
        } else if (departmentChoice ==2) {
            return "software";
        } else if (departmentChoice == 3) {
            return "hr";
        } else {
            return ""; }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*+-_+~`";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int randomPw = (int) (Math.random() * passwordSet.length()); // expression generates random number from passwordSet
            password[i] = passwordSet.charAt(randomPw);
        }
        return new String(password);
    }

    //Method to set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getPassword() {
        return password;
    }

    public String information() {
        return "Welcome to the doubleurizz team! Your employee login information is as follows: \nDisplay Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " +mailboxCapacity + "mbc";
    }


}
