import java.util.ArrayList;
import java.util.List;

// Car class will be used as Super Class to be inherited by its types Compact, SUV and Luxury
public class Car
{
    private int id;
    private String brand;
    private String model;
    private int year;
    private boolean rentalStatus;
    private double rentalFee;
    private double dummyRentalFee;
    private String plateNumber;
    private double distanceTravelled;
    private double damageCost;
    private int damagePercentage;
    private boolean damageStatus;
    private boolean insuranceStatus;
    private double insuranceCost;
    private String feature;
    private double luxuryTax;
    private boolean luxuryStatus;

    // Default Constructor
    public Car()
    {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.year = 0;
        this.rentalStatus = false;
        this.rentalFee = 0.0;
        this.dummyRentalFee = 0.0;
        this.plateNumber = "";
        this.distanceTravelled = 0.0;
        this.damageCost = 0.0;
        this.damagePercentage = 0;
        this.damageStatus = false;
        this.insuranceStatus = false;
        this.insuranceCost = 0.0;
        this.feature = "";
        this.luxuryStatus = false;
        this.luxuryTax = 0.0;
    }

    // Parameterized Constructor
    public Car(int id, String brand, String model, int year, boolean rentalStatus, double rentalFee, String plateNumber)
    {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalStatus = rentalStatus;
        this.rentalFee = rentalFee;
        this.dummyRentalFee = rentalFee;
        this.plateNumber = plateNumber;
        this.distanceTravelled = 0.0;
        this.damageCost = 0.0;
        this.damagePercentage = 0;
        this.damageStatus = false;
        this.insuranceStatus = false;
        this.insuranceCost = 0.0;
        this.feature = "";
        this.luxuryStatus = false;
        this.luxuryTax = 0.0;
    }

    // Getter and Setter Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public void setDummyRentalFee(double dummyRentalFee)
    {
        this.dummyRentalFee = dummyRentalFee;
    }

    public double getDummyRentalFee()
    {
        return dummyRentalFee;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(double damageCost) {
        this.damageCost = damageCost;
    }

    public int getDamagePercentage() {
        return damagePercentage;
    }

    public void setDamagePercentage(int damagePercentage) {
        this.damagePercentage = damagePercentage;
    }

    public boolean isDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(boolean damageStatus) {
        this.damageStatus = damageStatus;
    }

    public void setInsuranceStatus(boolean insuranceStatus)
    {
        this.insuranceStatus = insuranceStatus;
    }

    public boolean getInsuranceStatus()
    {
        return insuranceStatus;
    }

    public void setInsuranceCost(double insuranceCost)
    {
        this.insuranceCost = insuranceCost;
    }

    public double getInsuranceCost()
    {
        return insuranceCost;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }
    public String getFeature()
    {
        return feature;
    }

    public void setLuxuryStatus(boolean luxuryStatus)
    {
        this.luxuryStatus = luxuryStatus;
    }

    public void setLuxuryTax(double luxuryTax)
    {
        this.luxuryTax = luxuryTax;
    }
    public double getLuxuryTax()
    {
        return luxuryTax;
    }
    public boolean getLuxuryStatus()
    {
        return luxuryStatus;
    }

}

