import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testContactIdNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "JohnNameTooLong", "Smith", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Smith", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "SmithNameTooLong", "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testPhoneNotTenDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Smith", "123456789", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testPhoneNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Smith", null, "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Smith", "1234567890", "123 Main Street, Dallas, TX, 12345");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    public void testAddressNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Smith", "1234567890", null);
        });
        assertEquals("Invalid address", exception.getMessage());
    }
}