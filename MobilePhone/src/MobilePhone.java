import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber) {
        this.myNumber = phoneNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) != -1) // contact already exists
            return false;

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int foundPosition = findContact(oldContact);

        if (foundPosition == -1) // unable to update because old contact doesn't exists
            return false;
        else if (findContact(newContact.getName()) != -1) // unable to update because new contact already exists
            return false;

        this.myContacts.set(foundPosition, newContact); // sets new contact with an old contact's index
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition == -1) // unable to remove because contact doesn't exists
            return false;

        myContacts.remove(foundPosition);
        return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        int index = -1;

        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Contact queryContact(String name) {
        Contact contact = null;

        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                contact = myContacts.get(i);
                break;
            }
        }
        return contact;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i + 1 + ". " + myContacts.get(i).getName() + " -> " +
                    myContacts.get(i).getPhoneNumber());
        }
    }
}
