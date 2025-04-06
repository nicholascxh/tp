package utils.contacts.commands;

import utils.contacts.ContactsList;
import utils.contacts.Person;
import utils.contacts.PersonNotFoundException;

public class AddTagCommand extends ContactCommand {
    private ContactsList contactsList;
    private Person person;
    private String tag;

    public AddTagCommand(ContactsList contactsList, String name, String tag) throws PersonNotFoundException {
        this.contactsList = contactsList;
        this.person = contactsList.findName(name);
        this.tag = tag;
    }

    @Override
    public void execute() {
        contactsList.addTag(person, tag);
    }
}
