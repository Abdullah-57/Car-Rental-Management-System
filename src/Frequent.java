import java.util.ArrayList;
import java.util.List;

public class Frequent implements Rent
{
    private int id;
    private String name;
    private String email;
    private double totalRentalFee;
    private int phoneNumber;
    private String address;
    private final String feature;       // final variable to fix the Feature available for Frequent Renters
    private double featureDiscount;
    private List<Car> rentedCars;       // Aggregation: List of Rented Cars

    // Default Constructor
    public Frequent()
    {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.totalRentalFee = 0.0;
        this.phoneNumber = 0;
        this.address = "";
        this.feature = "Loyalty program with Discounted Rates.";
        this.featureDiscount = 0.0;
        this.rentedCars = new ArrayList<>();
    }

    // Parameterized Constructor
    public Frequent(int id, String name, String email, double totalRentalFee, int phoneNumber, String address)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.totalRentalFee = totalRentalFee;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.feature = "Loyalty program with Discounted Rates.";
        this.featureDiscount = 0.0;
        this.rentedCars = new ArrayList<>();
    }

    public Frequent(int id, String name, String email, double totalRentalFee, int phoneNumber, String address, List<Car> rentedCars)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.totalRentalFee = totalRentalFee;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.feature = "Standard Rent Rates.";
        this.featureDiscount = 0.0;
        this.rentedCars = rentedCars;
    }

    // Getter/Setters
    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public void setTotalRentalFee(double totalRentalFee)
    {
        this.totalRentalFee = totalRentalFee;
    }

    @Override
    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setAddress(String address)
    {
        this.address = address;
    }


    @Override
    public void setFeatureDiscount(double featureDiscount)
    {
        this.featureDiscount = featureDiscount;
    }

    @Override
    public void setRentedCars(List<Car> rentedCars)
    {
        this.rentedCars = rentedCars;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public double getTotalRentalFee()
    {
        return totalRentalFee;
    }

    @Override
    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String getAddress()
    {
        return address;
    }

    @Override
    public String getFeature()
    {
        return feature;
    }


    @Override
    public double getFeatureDiscount()
    {
        return featureDiscount;
    }

    @Override
    public List<Car> getRentedCars()
    {
        return rentedCars;
    }

    // Add Rented Car to the List
    @Override
    public void rentCar(Car car)
    {
        rentedCars.add(car);
        System.out.println("Car Added!");
    }

    // Remove Car from List
    @Override
    public void removeCar(Car car)
    {
        rentedCars.remove(car);
        System.out.println("Car Removed!");
    }

    // Display Renter Details
    @Override
    public void displayRenterDetails(Car car)
    {
        System.out.println("Renter Details: ");
        System.out.println("Renter ID: " + id);
        System.out.println("Renter Name: " + name);
        System.out.println("Renter Email: " + email);
        System.out.println("Renter Base Fee for Rented Car: " + car.getRentalFee());
        System.out.println("Renter Phone Number: " + phoneNumber);
        System.out.println("Renter Address: " + address);
    }

    // Calculate Rent for Frequent Customers
    @Override
    public void calculateRent(Car car)
    {
        if ((car.getLuxuryStatus() == true) && (car.isDamageStatus() == true) && (car.getInsuranceStatus() == true))
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getDamageCost() + car.getLuxuryTax();
            totalRentalFee -= car.getInsuranceCost();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Damage Cost: " + car.getDamageCost());
            System.out.println("Luxury Tax : " + car.getLuxuryTax());
            System.out.println("Insurance Cost: " + car.getInsuranceCost());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }
        else if ((car.getLuxuryStatus() == true) && (car.isDamageStatus() == true))
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getDamageCost() + car.getLuxuryTax();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Damage Cost: " + car.getDamageCost());
            System.out.println("Luxury Tax : " + car.getLuxuryTax());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");

        }
        else if ((car.getInsuranceStatus() == true) && (car.isDamageStatus() == true))
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getDamageCost();
            totalRentalFee -= car.getInsuranceCost();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Damage Cost: " + car.getDamageCost());
            System.out.println("Insurance Cost: " + car.getInsuranceCost());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }
        else if ((car.getLuxuryStatus() == true) && (car.getInsuranceStatus() == true))
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getLuxuryTax();
            totalRentalFee -= car.getInsuranceCost();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Luxury Tax : " + car.getLuxuryTax());
            System.out.println("Insurance Cost: " + car.getInsuranceCost());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }
        else if (car.isDamageStatus() == true)
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getDamageCost();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Damage Cost: " + car.getDamageCost());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }
        else if (car.getLuxuryStatus() == true)
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled() + car.getLuxuryTax();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Luxury Tax : " + car.getLuxuryTax());
            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }
        else
        {
            totalRentalFee = car.getDummyRentalFee() + car.getDistanceTravelled();
            featureDiscount = 0.25 * car.getDummyRentalFee();
            totalRentalFee -= featureDiscount;
            car.setRentalFee(totalRentalFee);

            System.out.println("Feature Discount for Frequent Renter: PKR" + featureDiscount + " from Rental Fee");
        }

        System.out.println("Total Rental Fee: " + "PKR" + totalRentalFee);
    }

    // Check Damage Percentage, If damage greater than 50, then increase the Damage Cost based on the type of Car, else stick to default Damage Cost
    @Override
    public void checkDamagePercentage(Car car, int damagePercentage)
    {
        if (car.getFeature().equals("Suitable for short-distance Travel."))
        {
            if (damagePercentage > 50)
            {
                car.setDamageCost(0.30 * car.getRentalFee());
            }
            else
            {
                return;
            }
        }
        else if (car.getFeature().equals("Spacious, suitable for Family Trips."))
        {
            if (damagePercentage > 50)
            {
                car.setDamageCost(0.40 * car.getRentalFee());
            }
            else
            {
                return;
            }
        }
        else if (car.getFeature().equals("High-End, suitable for special occasions."))
        {
            if (damagePercentage > 50)
            {
                car.setDamageCost(0.50 * car.getRentalFee());
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }
    }

    @Override
    public void displayCarDetails()
    {

    }

}