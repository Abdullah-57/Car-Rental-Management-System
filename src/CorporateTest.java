import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class CorporateTest
{

    @Test
    public void testRentCar()
    {
        Regular regularRenter = new Regular(1, "John Doe", "john.doe@example.com", 0, 123456, "123 Main St");
        Car car = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        regularRenter.rentCar(car);
        assertTrue(regularRenter.getRentedCars().contains(car));
    }

    @Test
    public void testRemoveCar()
    {
        Regular regularRenter = new Regular(1, "John Doe", "john.doe@example.com", 0, 123456, "123 Main St");
        Car car = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        regularRenter.rentCar(car);
        regularRenter.removeCar(car);
        assertFalse(regularRenter.getRentedCars().contains(car));
    }

    @Test
    public void testCalculateRent()
    {
        Corporate corporateRenter = new Corporate(1, "Corporate Company", "corporate@example.com", 0, 987654, "456 Business St");
        Car luxuryCarWithInsurance = new Luxury(1, "Mercedes", "S-Class", 2022, false, 80000, "MBZ-2022");
        luxuryCarWithInsurance.setInsuranceStatus(true);
        corporateRenter.rentCar(luxuryCarWithInsurance);

        double distanceTravelled = 150.75;
        luxuryCarWithInsurance.setDistanceTravelled(distanceTravelled);
        luxuryCarWithInsurance.setDamageStatus(true);
        luxuryCarWithInsurance.setDamagePercentage(15);

        corporateRenter.calculateRent(luxuryCarWithInsurance);

        assertEquals(80000 + distanceTravelled, luxuryCarWithInsurance.getDummyRentalFee(), 150.75);
        assertTrue(luxuryCarWithInsurance.getInsuranceStatus());
        assertTrue(luxuryCarWithInsurance.isDamageStatus());
        assertEquals(15, luxuryCarWithInsurance.getDamagePercentage());
    }

    @Test
    public void testCheckDamagePercentage()
    {
        Corporate corporateRenter = new Corporate(1, "Corporate Company", "corporate@example.com", 0, 987654, "456 Business St");
        Car highEndCar = new Luxury(1, "Mercedes", "S-Class", 2022, false, 80000, "MBZ-2022");
        highEndCar.setFeature("High-End, suitable for special occasions.");

        corporateRenter.checkDamagePercentage(highEndCar, 70);

        assertEquals(0.50 * highEndCar.getDummyRentalFee(), highEndCar.getDamageCost(), 0.01);
    }
}
