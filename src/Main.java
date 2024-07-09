import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Creating Scanner object input to take input from user
        Scanner input = new Scanner(System.in);

        // Creating CRMS object to handle both Car and Rental Management functions
        CRMS crms = new CRMS();

        boolean exit = false;

        // Do-While Loop in which the System will be running until user exits from the system
        do
        {
            System.out.println("Welcome to the CRMS Car Management System! ");
            System.out.println("Select any of the available options to perform your desired operation: ");
            System.out.println("1. Renter Management");
            System.out.println("2. Car Management");
            System.out.println("3. Display Transactions History");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");

            int crmsChoice = input.nextInt();

            switch (crmsChoice)
            {
                // Renter Management Functions
                case 1:
                    System.out.println("What Operation do you want to Perform? ");
                    System.out.println("1. Add Renter");
                    System.out.println("2. Remove Renter");
                    System.out.println("3. Display Renters");
                    System.out.println("Enter your Choice: ");
                    int renterChoice = input.nextInt();

                    if (renterChoice == 1)
                    {
                        // Input Details of Renter
                        System.out.print("Enter your ID: ");
                        int userId1 = input.nextInt();

                        input.nextLine();
                        System.out.print("Enter your name: ");
                        String userName1 = input.next();

                        input.nextLine();
                        System.out.print("Enter your email: ");
                        String userEmail1 = input.next();

                        System.out.print("Enter your phone number: ");
                        int userPhone1 = input.nextInt();

                        input.nextLine();
                        System.out.print("Enter your address: ");
                        String userAddress1 = input.next();

                        System.out.println("What type of Renter are you?");
                        System.out.println("1. Regular (Standard Rent Rates)");
                        System.out.println("2. Frequent (Loyalty program with Discounted Rates 25% off from Rental Fee)");
                        System.out.println("3. Corporate (Special rates for Corporate Clients 35% off from Rental Fee)");
                        System.out.print("Enter your choice: ");
                        int renterType1 = input.nextInt();

                        // Divide menu based on renter type for new renters

                        if (renterType1 == 1)
                        {
                            // Creating regular renters
                            Rent regularRenter = new Regular(userId1, userName1, userEmail1, 0, userPhone1, userAddress1);
                            crms.addRenter(regularRenter);
                        }
                        else if (renterType1 == 2)
                        {
                            // Creating frequent renters
                            Rent frequentRenter = new Frequent(userId1, userName1, userEmail1, 0, userPhone1, userAddress1);
                            crms.addRenter(frequentRenter);
                        }
                        else if (renterType1 == 3)
                        {
                            // Creating corporate renters
                            Rent corporateRenter = new Corporate(userId1, userName1, userEmail1, 0, userPhone1, userAddress1);
                            crms.addRenter(corporateRenter);
                        }
                        else
                        {
                            System.out.println("Invalid Renter Type! Try Again!");
                        }
                    }
                    else if (renterChoice == 2)
                    {
                        // Remove Renter by taking Renter ID as Input
                        System.out.print("Enter Renter ID: ");
                        int renterId = input.nextInt();

                        Rent removeRenter = crms.findRenter(renterId);
                        crms.removeRenter(removeRenter);
                    }
                    else if (renterChoice == 3)
                    {
                        // Display All Renters Added
                        crms.displayRenters();
                    }
                    else
                    {
                        System.out.println("Invalid Renter Operation! Try Again!");
                    }

                    break;

                case 2:
                    // Car Management Functions
                    System.out.println("What Operation do you want to Perform? ");
                    System.out.println("1. Add Car and Rent to Renter");
                    System.out.println("2. Return Car and Remove Renter");
                    System.out.println("3. Remove Unrented Car");
                    System.out.println("4. Display Cars");
                    System.out.println("Enter your Choice: ");
                    int carChoice = input.nextInt();

                    // Input all car details to rent it to a renter
                    if (carChoice == 1)
                    {
                        System.out.println("Enter Details for the Car you want to Add ");

                        System.out.print("Enter ID: ");
                        int carId = input.nextInt();

                        input.nextLine();
                        System.out.print("Enter Brand: ");
                        String carBrand = input.nextLine();

                        input.nextLine();
                        System.out.print("Enter Model: ");
                        String carModel = input.nextLine();

                        System.out.print("Enter Year: ");
                        int carYear = input.nextInt();

                        System.out.print("Enter Rental Fee: ");
                        double carRentalFee = input.nextDouble();

                        input.nextLine();
                        System.out.print("Enter Plate Number: ");
                        String carPlateNumber = input.nextLine();

                        System.out.println("Enter Type of Car: ");
                        System.out.println("1. Compact (Insurance Unavailable)");
                        System.out.println("2. SUV (Insurance: Available)");
                        System.out.println("3. Luxury (Insurance: Available) (Luxury Tax also Applied)");
                        int type = input.nextInt();

                        if (type == 1)
                        {
                            // Creating compact car object and renting it to specified renter
                            Car compactCar = new Compact(carId, carBrand, carModel, carYear, false, carRentalFee, carPlateNumber);

                            System.out.print("Enter Renter ID: ");
                            int renterId = input.nextInt();

                            Rent rentedCar = crms.findRenter(renterId);

                            rentedCar.rentCar(compactCar);
                            compactCar.setRentalStatus(true);
                        }
                        else if (type == 2)
                        {
                            // Creating SUV car object and renting it to specified renter
                            Car suvCar = new SUV(carId, carBrand, carModel, carYear, false, carRentalFee, carPlateNumber);

                            System.out.print("Enter Renter ID: ");
                            int renterId = input.nextInt();

                            Rent rentedCar = crms.findRenter(renterId);

                            // Asking if Renter wants Insurance
                            System.out.println("Do you want to add Insurance? (15% of Rental Fee) (Enter 1 for Yes, Enter 0 for No)");
                            int insurance = input.nextInt();

                            if (insurance == 1)
                            {
                                suvCar.setInsuranceStatus(true);
                            }
                            else if (insurance == 0)
                            {
                                suvCar.setInsuranceStatus(false);
                            }
                            else
                            {
                                System.out.println("Invalid Insurance Option! Try Again!");
                            }

                            rentedCar.rentCar(suvCar);
                            suvCar.setRentalStatus(true);
                        }
                        else if (type == 3)
                        {
                            // Creating Luxury car object and renting it to specified renter
                            Car luxuryCar = new Luxury(carId, carBrand, carModel, carYear, false, carRentalFee, carPlateNumber);

                            System.out.print("Enter Renter ID: ");
                            int renterId = input.nextInt();

                            Rent rentedCar = crms.findRenter(renterId);

                            System.out.println("Do you want to add Insurance? (15% of Rental Fee) (Enter 1 for Yes, Enter 0 for No)");
                            int insurance = input.nextInt();

                            // Asking if Renter wants Insurance
                            if (insurance == 1)
                            {
                                luxuryCar.setInsuranceStatus(true);
                            }
                            else if (insurance == 0)
                            {
                                luxuryCar.setInsuranceStatus(false);
                            }
                            else
                            {
                                System.out.println("Invalid Insurance Option! Try Again!");
                            }

                            rentedCar.rentCar(luxuryCar);
                            luxuryCar.setRentalStatus(true);
                        }
                        else
                        {
                            System.out.println("Invalid Car Operation! Try Again!");
                        }
                    }
                    else if (carChoice == 2)
                    {
                        // Return a Car to Remove Renter by providing all details after using the car
                        System.out.print("Enter Car ID: ");
                        int carId = input.nextInt();

                        System.out.print("Enter Renter ID: ");
                        int renterId = input.nextInt();

                        Car removeCar = crms.findCar(carId);
                        Rent removeRenter = crms.findRenter(renterId);

                        double distanceTravelled = 0;
                        int damageVariable = 0;
                        int damagePercentage = 0;

                        // Distance
                        System.out.println("How much Distance did you travel? (Enter in Decimals)");
                        distanceTravelled = input.nextDouble();

                        removeCar.setDistanceTravelled(distanceTravelled);

                        // Damage
                        System.out.println("Did you Damage the Car? (Enter 1 for Yes, Enter 0 for No)");
                        damageVariable = input.nextInt();

                        if (damageVariable == 1)
                        {
                            removeCar.setDamageStatus(true);

                            System.out.println("If you had to guess, in percentage, how much damage did you do to the car?");
                            damagePercentage = input.nextInt();

                            removeCar.setDamagePercentage(damagePercentage);
                            removeRenter.checkDamagePercentage(removeCar, damagePercentage);
                        }
                        else
                        {
                            removeCar.setDamageStatus(false);
                        }

                        removeRenter.calculateRent(removeCar);
                        crms.storeTransactions(removeRenter);
                        removeCar.setRentalStatus(false);
                    }
                    else if (carChoice == 3)
                    {
                        // Remove all Cars with Rental Status false
                        crms.removeUnrentedCars();
                    }
                    else if (carChoice == 4)
                    {
                        // Display all Cars
                        crms.displayCars();
                    }
                    else
                    {
                        System.out.println("Invalid Car Operation! Try Again!.");
                    }

                    break;

                case 3:
                    // Display all Transactions
                    crms.displayTransactions();

                    System.out.println();
                    break;

                case 4:
                    // Exit the System
                    System.out.println("Thank You for using the CRMS Car Management System! ");
                    exit = true;

                    break;

                default:
                    // Handle Exceptions
                    System.out.println("Invalid Choice! Terminating Program!");
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}
