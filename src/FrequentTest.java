import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class FrequentTest
{

    @Test
    public void testRentCarAndRemoveCar()
    {
        Frequent frequentRenter = new Frequent(1, "Jane Doe", "jane.doe@example.com", 0, 789012, "456 Oak St");
        Car regularCar = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");

        frequentRenter.rentCar(regularCar);
        assertTrue(frequentRenter.getRentedCars().contains(regularCar));

        frequentRenter.removeCar(regularCar);
        assertFalse(frequentRenter.getRentedCars().contains(regularCar));
    }

    @Test
    public void testCalculateRent()
    {
        Frequent frequentRenter = new Frequent(1, "Jane Doe", "jane.doe@example.com", 0, 789012, "456 Oak St");
        Luxury luxuryCarWithInsurance = new Luxury(1, "Mercedes", "S-Class", 2022, true, 80000, "ABC-567");
        luxuryCarWithInsurance.setInsuranceStatus(true);

        double distanceTravelled = 150.7;
        luxuryCarWithInsurance.setDistanceTravelled(distanceTravelled);
        luxuryCarWithInsurance.setDamageStatus(true);
        luxuryCarWithInsurance.setDamagePercentage(25);

        frequentRenter.calculateRent(luxuryCarWithInsurance);

        assertEquals(80000 + distanceTravelled, luxuryCarWithInsurance.getDummyRentalFee(), 150.7);
        assertTrue(luxuryCarWithInsurance.getInsuranceStatus());
        assertTrue(luxuryCarWithInsurance.isDamageStatus());
        assertEquals(25, luxuryCarWithInsurance.getDamagePercentage());
        assertEquals(0.25 * (80000 + distanceTravelled), frequentRenter.getFeatureDiscount(), 150.7);
    }

    @Test
    public void testCheckDamagePercentage()
    {
        Frequent frequentRenter = new Frequent(1, "Jane Doe", "jane.doe@example.com", 0, 789012, "456 Oak St");
        Luxury luxuryCar = new Luxury(1, "Mercedes", "S-Class", 2022, true, 80000, "ABC-567");

        frequentRenter.checkDamagePercentage(luxuryCar, 60);
        assertEquals(0.50 * 80000, luxuryCar.getDamageCost(), 0.01);
    }
}
