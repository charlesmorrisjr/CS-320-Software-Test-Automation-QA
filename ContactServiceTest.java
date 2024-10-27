import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertFalse(contactService.addContact(contact)); // Adding the same contact again should fail
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("1"));
        assertFalse(contactService.deleteContact("1")); // Deleting again should fail
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertTrue(contactService.updateContact("1", "Jane", "Doe", "0987654321", "456 Elm Dr"));
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm Dr", contact.getAddress());

        assertFalse(contactService.updateContact("2", "Jane", "Doe", "0987654321", "456 Elm Dr")); // Non-existent ID
    }
}