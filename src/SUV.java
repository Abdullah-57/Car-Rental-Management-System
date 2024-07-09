public class SUV extends Car
{

    public SUV()
    {
        this.setFeature("Spacious, suitable for Family Trips.");
        this.setInsuranceStatus(false);
        this.setInsuranceCost(0.10 * getDummyRentalFee());           // Setting Insurance Cost of SUV Car to 10% of Original Car Rental Fee
        this.setDamageCost(0.20 * getDummyRentalFee());              // Setting Default Damage Cost of SUV Car to 20% of Original Car Rental Fee
        this.setDamageStatus(false);
    }

    public SUV(int id, String brand, String model, int year, boolean rentalStatus, double rentalFee, String plateNumber)
    {
        super(id, brand, model, year, rentalStatus, rentalFee, plateNumber);
        this.setFeature("Spacious, suitable for Family Trips.");
        this.setInsuranceStatus(false);
        this.setInsuranceCost(0.10 * getDummyRentalFee());       // Setting Insurance Cost of SUV Car to 10% of Original Car Rental Fee
        this.setDamageCost(0.20 * getDummyRentalFee());          // Setting Default Damage Cost of SUV Car to 20% of Original Car Rental Fee
        this.setDamageStatus(false);
    }
}
