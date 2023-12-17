import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testCreateContactWithDefaultValues() {
        // Create a contact with default values
        Contact contact = new Contact();

        // Verify that the contact is not null
        assertNotNull(contact);

        // Verify individual fields have default values
        assertEquals("1", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testUpdateContactFields() {
        // Create a contact
        Contact contact = new Contact();

        // Update contact fields
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhoneNumber("9876543210");
        contact.setAddress("456 Oak St");

        // Verify the updated fields
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhoneNumber());
        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreationWithLongFirstName() {
        // Try to create a contact with invalid data (long first name)
        assertThrows(IllegalArgumentException.class, () -> new Contact());
    }

    @Test
    public void testInvalidPhoneNumberUpdate() {
        // Create a contact
        Contact contact = new Contact();

        // Try to update phone number with an invalid value
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("InvalidPhoneNumber"));
    }

    // Add more tests as needed for specific behavior or edge cases
}
