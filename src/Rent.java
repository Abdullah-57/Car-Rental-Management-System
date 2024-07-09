import java.util.List;
import java.util.ArrayList;

// Interface for Rent Class to implement Polymorphism for 3 Different types of Renters Regular, Frequent and Corporate
public interface Rent
{
    public void setId(int id);
    public void setName(String name);
    public void setEmail(String email);
    public void setTotalRentalFee(double totalRentalFee);
    public void setPhoneNumber(int phoneNumber);
    public void setAddress(String address);
    public void setRentedCars(List<Car> rentedCars);
    public void setFeatureDiscount(double featureDiscount);
    public int getId();
    public String getName();
    public String getEmail();
    public double getTotalRentalFee();
    public int getPhoneNumber();
    public String getAddress();
    public List<Car> getRentedCars();
    public String getFeature();
    public void rentCar(Car car);
    public void removeCar(Car car);
    public void displayCarDetails();
    public void displayRenterDetails(Car car);
    public void calculateRent(Car car);
    public double getFeatureDiscount();
    public void checkDamagePercentage(Car car, int damagePercentage);
}
