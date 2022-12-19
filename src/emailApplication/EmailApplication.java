package emailApplication;
import java.util.Scanner;


public class EmailApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Greetings! What is your first name?");
        String firstName = scanner.nextLine();
        System.out.println("Wowzers! May I get your last name as well?");
        String lastName = scanner.nextLine();
        Email email = new Email(firstName, lastName);
        System.out.println(email.information());
    }

}
