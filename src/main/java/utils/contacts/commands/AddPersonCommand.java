package utils.contacts.commands;

import utils.contacts.ContactsList;
import utils.contacts.Person;
import utils.contacts.SameNameException;

public class AddPersonCommand extends ContactCommand {
    ContactsList contactsList;
    String name;
    String contactNumber;
    String email;
    Person person;

    public AddPersonCommand(ContactsList contactsList, String name) throws SameNameException {
        this.contactsList = contactsList;
        this.name = name;
        if (contactsList.hasPerson(name)) {
            throw new SameNameException("This person already exists");
        }
    }

    public AddPersonCommand(ContactsList contactsList, String name, String contactNumber) throws SameNameException {
        this.contactsList = contactsList;
        this.name = name;
        this.contactNumber = contactNumber;
        if (contactsList.hasPerson(name)) {
            throw new SameNameException("This person already exists");
        }
    }

    public AddPersonCommand(ContactsList contactsList, String name, String contactNumber, String email)
            throws SameNameException {
        this.contactsList = contactsList;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        if (contactsList.hasPerson(name)) {
            throw new SameNameException("This person already exists");
        }
    }

    @Override
    public void execute() {
        assert !contactsList.hasPerson(name);
        person = new Person(name);
        assert contactNumber.matches("\\d+");
        person.setContactNumber(contactNumber);
        assert email.contains("@");
        person.setEmail(email);
        contactsList.addPerson(person);
        System.out.println("The following person is added to the contact book:");
        System.out.println(person.showDetails());
    }
}
