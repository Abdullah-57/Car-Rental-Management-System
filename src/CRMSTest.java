import static org.junit.Assert.*;
import org.junit.Test;

public class CRMSTest
{

    @Test
    public void testAddRenter()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 3324342, "123 Main St");
        crms.addRenter(renter);
        assertTrue(crms.renters.contains(renter));
    }

    @Test
    public void testRemoveRenter()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        crms.addRenter(renter);
        crms.removeRenter(renter);
        assertFalse(crms.renters.contains(renter));
    }

    @Test
    public void testFindRenter()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        crms.addRenter(renter);
        assertEquals(renter, crms.findRenter(1));
    }

    @Test
    public void testFindRenterNotFound()
    {
        CRMS crms = new CRMS();
        assertNull(crms.findRenter(1));
    }

    @Test
    public void testFindCar()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        Car car = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        renter.rentCar(car);
        crms.addRenter(renter);
        assertEquals(car, crms.findCar(1));
    }

    @Test
    public void testFindCarNotFound()
    {
        CRMS crms = new CRMS();
        assertNull(crms.findCar(1));
    }

    @Test
    public void testStoreTransactions()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        crms.storeTransactions(renter);
        assertTrue(crms.rentTransactions.contains(renter));
    }

    @Test
    public void testDisplayTransactions()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        Car car = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        renter.rentCar(car);
        crms.storeTransactions(renter);
        crms.displayTransactions();
    }

    @Test
    public void testDisplayRenters()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        crms.addRenter(renter);
        crms.displayRenters();
    }

    @Test
    public void testDisplayCars()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        Car car = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        renter.rentCar(car);
        crms.addRenter(renter);
        crms.displayCars();
    }

    @Test
    public void testRemoveUnrentedCars()
    {
        CRMS crms = new CRMS();
        Rent renter = new Regular(1, "John Doe", "john.doe@example.com", 123456, 1, "123 Main St");
        Car rentedCar = new Compact(1, "Toyota", "Corolla", 2017, true, 10000, "BAU-199");
        Car unrentedCar = new Compact(2, "Honda", "Civic", 2018, false, 12000, "XYZ-123");
        renter.rentCar(rentedCar);
        renter.rentCar(unrentedCar);
        crms.addRenter(renter);
        crms.removeUnrentedCars();
        assertFalse(renter.getRentedCars().contains(unrentedCar));
    }
}
