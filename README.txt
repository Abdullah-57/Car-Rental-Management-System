Car Rental Management System (CRMS)

Project Description:
The Car Rental Management System (CRMS) is a console-based application developed in Java to efficiently manage a car rental company's operations. This system manages different types of cars, renters, and the rental transactions between them. It utilizes Object-Oriented Programming (OOP) principles such as encapsulation, abstraction, polymorphism, inheritance, composition, and aggregation.

Features:

Car Management:
	Add new cars of different types (Compact, SUV, Luxury).
	Display available cars.
	Remove a car if it is not rented.

Renter Management:
	Add new renters of different types (Regular, Frequent, Corporate).
	Display renter details.
	Remove a renter after they return the car.

Rent Transactions:
	Rent a car to a renter.
	Display rental details.
	Calculate and display the total rental cost.
	Provide an option to add insurance if the rented car is insurable.
	Calculate and include insurance cost in the total.
	Calculate and display damage cost based on the car type and insurance status upon return.
	Store all rent transactions in the CRMS.

Damage Cost Calculation:
	For all cars: Damage cost is a percentage of the total cost decided by the company if un-insured.
	For insured cars: Damage cost is a percentage of the total cost minus the insurance but with a minimum set if damage is apparent.

Classes and Key Functions:

Car (Base Class):
	Properties: carID, brand, model, year, rentalStatus, rentalFee, plateNumber
	Methods: Getters and setters, rentCalculation(), isInsurable()

CompactCar (Inherits Car):
	Features: Basic features, suitable for short-distance travel.
	Rent Calculation Formula: Base rent + distance traveled cost.
	Insurable: No.

SUV (Inherits Car):
	Features: Spacious, suitable for family trips.
	Rent Calculation Formula: Base rent + distance traveled cost.
	Insurable: Yes (Fixed percentage of the base rent; Damage cost: Percentage of the base rent).

LuxuryCar (Inherits Car):
	Features: High-end, suitable for special occasions.
	Rent Calculation Formula: Base rent + distance traveled cost + luxury tax.
	Insurable: Yes (Fixed percentage of the base rent; Damage cost: Percentage of the total cost including luxury tax).

Renter (Base Class):
	Properties: renterID, name, email, rentedCars (List of Cars), totalRentalFee, phoneNumber, address
	Methods: Getters and setters

RegularRenter (Inherits Renter):
	Features: Standard rent rates.

FrequentRenter (Inherits Renter):
	Features: Loyalty program with discounted rates.

CorporateRenter (Inherits Renter):
	Features: Special rates for corporate clients.

Usage:

Add Cars:
	Use the menu to add new cars of different types.

Add Renters:
	Use the menu to add new renters of different types.

Rent a Car:
	Select a car and a renter from the available lists.
	Choose whether to add insurance if the car is insurable.
	Confirm the rental to complete the transaction.

Return a Car:
	Select a car to return.
	The system will calculate the total rental cost and any applicable damage costs.
	Confirm the return to complete the process.

Testing:
	The project includes sample test cases demonstrating the program's functionality.
	JUnit test cases are provided for all developed classes and requested functionalities.

Contributing:
	Contributions are welcome! Please follow these steps:
		Fork the repository.
		Create a new branch (git checkout -b feature-branch).
		Commit your changes (git commit -m 'Add some feature').
		Push to the branch (git push origin feature-branch).
		Open a pull request.

Acknowledgments:
	This project was developed as part of a software engineering course at FAST National University of Computer and Emerging Sciences.
	Special thanks to the course instructor and teaching assistants for their support and guidance.
