public class Luxury extends Car
{

    public Luxury()
    {
        this.setFeature("High-End, suitable for special occasions.");
        this.setInsuranceStatus(false);
        this.setInsuranceCost(0.15 * getDummyRentalFee());               // Setting Insurance Cost of Luxury Car to 15% of Original Car Rental Fee
        this.setLuxuryStatus(true);
        this.setLuxuryTax(0.50 * getDummyRentalFee());                   // Setting Luxury Car Tax to 50% of Original Car Rental Fee
        this.setDamageCost(0.30 * getDummyRentalFee());                  // Setting Default Damage Cost of Luxury Car to 30% of Original Car Rental Fee
        this.setDamageStatus(false);
    }

    public Luxury(int id, String brand, String model, int year, boolean rentalStatus, double rentalFee, String plateNumber)
    {
        super(id, brand, model, year, rentalStatus, rentalFee, plateNumber);
        this.setFeature("High-End, suitable for special occasions.");
        this.setInsuranceStatus(false);
        this.setInsuranceCost(0.15 * getDummyRentalFee());               // Setting Insurance Cost of Luxury Car to 15% of Original Car Rental Fee
        this.setLuxuryStatus(true);
        this.setLuxuryTax(0.50 * getDummyRentalFee());                    // Setting Luxury Car Tax to 50% of Original Car Rental Fee
        this.setDamageCost(0.30 * getDummyRentalFee());                  // Setting Default Damage Cost of Luxury Car to 30% of Original Car Rental Fee
        this.setDamageStatus(false);
    }

}
