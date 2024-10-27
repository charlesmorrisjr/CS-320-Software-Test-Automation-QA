import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a contact with a unique ID
    public boolean addContact(Contact contact) {
    	if (contacts.containsKey(contact.getContactId())) {
            return false; // If ID already exists, return false
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Delete a contact by ID
    public boolean deleteContact(String contactId) {
        if (contacts.containsKey(contactId)) {
            contacts.remove(contactId);
            return true;
        }
        return false; // If ID does not exist, return false
    }

    // Update contact fields by ID
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            Contact contact = contacts.get(contactId);
            if (firstName != null && !firstName.isEmpty()) {
                contact.setFirstName(firstName);
            }
            if (lastName != null && !lastName.isEmpty()) {
                contact.setLastName(lastName);
            }
            if (phone != null && !phone.isEmpty()) {
                contact.setPhone(phone);
            }
            if (address != null && !address.isEmpty()) {
                contact.setAddress(address);
            }
            return true;
        }
        return false; // ID does not exist
    }
}