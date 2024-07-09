import static org.junit.Assert.*;
import org.junit.Test;

public class RegularTest
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
        Regular regularRenter = new Regular(1, "John Doe", "john.doe@example.com", 0, 123456, "123 Main St");
        Car luxuryCarWithInsurance = new Luxury(1, "Nissan", "Skyline", 2009, false, 50000, "VCE-1986");
        luxuryCarWithInsurance.setInsuranceStatus(true);
        regularRenter.rentCar(luxuryCarWithInsurance);

        double distanceTravelled = 200.5;
        luxuryCarWithInsurance.setDistanceTravelled(distanceTravelled);
        luxuryCarWithInsurance.setDamageStatus(true);
        luxuryCarWithInsurance.setDamagePercentage(20);

        regularRenter.calculateRent(luxuryCarWithInsurance);

        assertEquals(50000 + distanceTravelled, luxuryCarWithInsurance.getDummyRentalFee(), 200.5);
        assertTrue(luxuryCarWithInsurance.getInsuranceStatus());
        assertTrue(luxuryCarWithInsurance.isDamageStatus());
        assertEquals(20, luxuryCarWithInsurance.getDamagePercentage());
    }

    @Test
    public void testCheckDamagePercentage()
    {
        Regular regularRenter = new Regular(1, "John Doe", "john.doe@example.com", 0, 123456, "123 Main St");

        Car shortDistanceCar = new Compact(1, "Toyota", "Corolla", 2017, false, 10000, "BAU-199");
        shortDistanceCar.setFeature("Suitable for short-distance Travel.");

        Car familyCar = new SUV(2, "Mazda", "X6", 2020, false, 17000, "LSPD-1875");
        familyCar.setFeature("Spacious, suitable for Family Trips.");

        Car highEndCar = new Luxury(3, "Nissan", "Skyline", 2009, false, 50000, "VCE-1986");
        highEndCar.setFeature("High-End, suitable for special occasions.");

        regularRenter.checkDamagePercentage(shortDistanceCar, 60);
        regularRenter.checkDamagePercentage(familyCar, 55);
        regularRenter.checkDamagePercentage(highEndCar, 70);

        assertEquals(0.30 * shortDistanceCar.getDummyRentalFee(), shortDistanceCar.getDamageCost(), 0.01);
        assertEquals(0.40 * familyCar.getDummyRentalFee(), familyCar.getDamageCost(), 0.01);
        assertEquals(0.50 * highEndCar.getDummyRentalFee(), highEndCar.getDamageCost(), 0.01);
    }
}
