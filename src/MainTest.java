import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    public void testAddRenter() {
        // Creating a CRMS object for testing
        CRMS crms = new CRMS();

        // Mocking user input for adding a renter
        String input = "1\n1\n123\nJohn Doe\njohn.doe@example.com\n123456\n123 Main St\n1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Running the main function
        Main.main(null);

        // Retrieving the added renter
        Rent addedRenter = crms.findRenter(123);

        // Asserting that the renter was added successfully
        assertNotNull(addedRenter);
        assertEquals("John Doe", addedRenter.getName());
        assertEquals("john.doe@example.com", addedRenter.getEmail());
        assertEquals(123456, addedRenter.getPhoneNumber());
        assertEquals("123 Main St", addedRenter.getAddress());
        assertEquals(1, addedRenter.getFeature());
    }
}
