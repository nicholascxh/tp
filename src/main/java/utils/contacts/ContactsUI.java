package utils.contacts;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ContactsUI {

    public static Person handlePersonInputUI(ContactsList contactsList, Scanner scanner, String instruction,
                                             Person lender) {
        Person person;
        while (true) {
            System.out.print(instruction + "\n> ");
            String name = scanner.nextLine().trim();
            if (lender != null && name.equals(lender.getName())) {
                System.out.println("The borrower must be different from the lender");
            } else {
                try {
                    if (contactsList.hasPerson(name)) {
                        person = contactsList.findName(name);
                        break;
                    } else {
                        person = addPersonInputUI(scanner, name);
                        contactsList.addPerson(person);
                        System.out.println("New person [" + name + "] is added to the contact book.");
                        break;
                    }
                } catch (EmptyNameException e) {
                    System.out.println("Name cannot be empty");
                }
            }
        }
        return person;
    }

    public static String addEmailInputUI(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Enter the person's E-Mail (Enter N/A if not applicable):\n> ");
            String input = scanner.nextLine().trim();
            if (input.equals("N/A")) {
                return null;
            } else if (input.matches(".*@.*")) {
                email = input;
                break;
            } else {
                System.out.println("It seems that your email input is incorrect.");
            }
        }
        return email;
    }

    public static String addContactNumberInputUI(Scanner scanner) {
        Pattern pattern = Pattern.compile("\\d+");
        String number;
        while (true) {
            System.out.print("Enter the person's contact number (Enter N/A if not applicable):\n> ");
            String input = scanner.nextLine().trim();
            if (input.equals("N/A")) {
                return null;
            } else if (pattern.matcher(input).find()) {
                number = input;
                break;
            } else {
                System.out.println("It seems that your number input is incorrect.");
            }
        }
        return number;
    }

    public static Person addPersonInputUI(Scanner scanner, String name) {
        Person person = new Person(name);
        System.out.println("New person: [" + name + "]");
        String contactNumber = addContactNumberInputUI(scanner);
        String email = addEmailInputUI(scanner);
        person.setContactNumber(contactNumber);
        person.setEmail(email);
        return person;
    }
}
