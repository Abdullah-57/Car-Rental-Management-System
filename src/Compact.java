public class Compact extends Car
{
    public Compact()
    {
        this.setFeature("Suitable for short-distance Travel.");
        this.setDamageCost(0.15 * getDummyRentalFee());                  // Setting Default Damage Cost of Compact Car to 15% of Original Car Rental Fee
        this.setDamageStatus(false);
    }

    public Compact(int id, String brand, String model, int year, boolean rentalStatus, double rentalFee, String plateNumber)
    {
        super(id, brand, model, year, rentalStatus, rentalFee, plateNumber);
        this.setFeature("Suitable for short-distance Travel.");
        this.setDamageCost(0.15 * getDummyRentalFee());                  // Setting Default Damage Cost of Compact Car to 15% of Original Car Rental Fee
        this.setDamageStatus(false);
    }

}
