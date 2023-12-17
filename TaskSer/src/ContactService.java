import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a contact with a unique ID
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactID() + " already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact per contact ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found.");
        }
        contacts.remove(contactID);
    }

    // Update contact fields per contact ID
    public void updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found.");
        }

        Contact contact = contacts.get(contactID);

        // Update only the specified fields
        if (firstName != null) {
            contact.setLastName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Getter to retrieve a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    // Getter to retrieve all contacts
    public Map<String, Contact> getAllContacts() {
        return contacts;
    }

    public static void main(String[] args) {
        // Example Usage
        ContactService contactService = new ContactService();

        // Add contact
        Contact contact = new Contact();
        contactService.addContact(contact);

        // Print all contacts
        System.out.println("All Contacts:");
        contactService.getAllContacts().forEach((id, c) -> System.out.println(c));

        // Update contact
        contactService.updateContact("1", "Jane", null, null, "456 Oak St");

        // Print updated contact
        System.out.println("\nUpdated Contact:");
        System.out.println(contactService.getContact("1"));

        // Delete contact
        contactService.deleteContact("1");

        // Print all contacts after deletion
        System.out.println("\nAll Contacts after Deletion:");
        contactService.getAllContacts().forEach((id, c) -> System.out.println(c));
    }
}