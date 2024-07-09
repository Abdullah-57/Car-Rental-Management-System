import javax.lang.model.type.NullType;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CRMS
{
    public List<Rent> renters;
                                            // Composition of Renters and Renter Transactions
    public List<Rent> rentTransactions;

    public List<Car> retrievedCars;

    public static int totalRenters;         // Static variable to keep track of Total Renters

    // Default Constructor
    public CRMS()
    {
        totalRenters = 0;
        this.renters = new ArrayList<>();
        this.rentTransactions = new ArrayList<>();
        this.retrievedCars = new ArrayList<>();
    }

    // Add Renters to List
    public void addRenter(Rent renter)
    {
        renters.add(renter);
        totalRenters++;
        System.out.println("Renter Added! ");
    }

    // Remove Renters from List
    public void removeRenter(Rent renter)
    {
        if (renter != null)
        {
            // Detach rented cars from the renter
            retrievedCars = renter.getRentedCars();

            for (Car car : retrievedCars)
            {
                car.setRentalStatus(false);
            }

            // Remove the renter from the system
            renters.remove(renter);
        }

        totalRenters--;
        System.out.println("Renter Removed!" );
    }

    // Find Renter from Renters List
    public Rent findRenter(int renterId)
    {
        for (Rent renter : renters)
        {
            if (renter.getId() == renterId)
            {
                return renter;
            }
        }

        return null;
    }

    // Find Car from Car List inside each Renter
    public Car findCar(int carId)
    {
        for (Rent renter : renters)
        {
           for (Car car : renter.getRentedCars())
           {
               if (car.getId() == carId)
               {
                   return car;
               }
           }
        }

        return null;
    }

    // Store all Transactions of Renters after returning the Cars
    public void storeTransactions(Rent renter)
    {
        rentTransactions.add(renter);
    }

    // Display All Transactions
    public void displayTransactions()
    {
        System.out.println("Transactions: ");
        System.out.println();

        for (Rent renter : rentTransactions)
        {
            System.out.println("Renter ID: " + renter.getId());
            System.out.println("Renter Name: " + renter.getName());
            System.out.println("Renter Email: " + renter.getEmail());
            System.out.println("Renter Phone Number: " + renter.getPhoneNumber());
            System.out.println("Renter Address: " + renter.getAddress());

            for (Car car : renter.getRentedCars())
            {
                System.out.println("Car Transaction Completed for: " + car.getRentalFee());
            }

            System.out.println();
        }
    }

    // Display All Renters
    public void displayRenters()
    {
        System.out.println("Renter Details: ");
        System.out.println();
        System.out.println("Total Renters: " + totalRenters);

        for (Rent renter : renters)
        {
            System.out.println("Renter ID: " + renter.getId());
            System.out.println("Renter Name: " + renter.getName());
            System.out.println("Renter Email: " + renter.getEmail());
            System.out.println("Renter Phone Number: " + renter.getPhoneNumber());
            System.out.println("Renter Address: " + renter.getAddress());
        }
        System.out.println();
    }

    // Display All Cars
    public void displayCars()
    {
        System.out.println("Car Details: ");

        for (Rent renter : renters)
        {
            for (Car car : renter.getRentedCars())
            {
                System.out.println("Car ID: " + car.getId());
                System.out.println("Car Brand: " + car.getBrand());
                System.out.println("Car Model: " + car.getModel());
                System.out.println("Car Year: " + car.getYear());
                System.out.println("Car Feature: " + car.getFeature());
                System.out.println("Car Rental Status: " + car.isRentalStatus());
                System.out.println("Car Rental Fee: " + car.getDummyRentalFee());
                System.out.println("Car Plate Number: " + car.getPlateNumber());
            }
        }

        for (Car car : retrievedCars)
        {
            System.out.println("Car ID: " + car.getId());
            System.out.println("Car Brand: " + car.getBrand());
            System.out.println("Car Model: " + car.getModel());
            System.out.println("Car Year: " + car.getYear());
            System.out.println("Car Feature: " + car.getFeature());
            System.out.println("Car Rental Status: " + car.isRentalStatus());
            System.out.println("Car Rental Fee: " + car.getDummyRentalFee());
            System.out.println("Car Plate Number: " + car.getPlateNumber());
        }

        System.out.println();
    }

    // Remove Cars whose Rental Status is False
    public void removeUnrentedCars()
    {
        for (Rent renter : renters)
        {
            for (int i = renter.getRentedCars().size() - 1; i >= 0; i--)
            {
                if (!renter.getRentedCars().get(i).isRentalStatus())
                {
                    System.out.println("Removing Car " + renter.getRentedCars().get(i));
                    renter.getRentedCars().remove(i);
                }
            }
        }

        for (int i = retrievedCars.size() - 1; i >= 0; i--)
        {
            Car car = retrievedCars.get(i);
            if (!car.isRentalStatus())
            {
                System.out.println("Removing Car " + car.getId() + " " + car.getBrand());
                retrievedCars.remove(i);
            }
        }
    }
}
