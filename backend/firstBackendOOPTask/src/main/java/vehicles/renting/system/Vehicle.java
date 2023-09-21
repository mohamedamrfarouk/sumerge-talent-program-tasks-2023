package vehicles.renting.system;

public abstract class Vehicle {
    private static int vehiclesCount=0;
    protected static double totalRevenue=0;
    private int registrationNumber;
    private String brand ;
    private int year;
    private String type;
    protected double rentalRate;

    protected boolean rented = false;

    Vehicle(int registrationNumber, String brand, int year, String type, double rentalRate){
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.year = year;
        this.type = type;
        this.rentalRate=rentalRate;
        Vehicle.vehiclesCount++;
    }
    public double  calculateRentalCost(int rentalPeriod){
        Vehicle.totalRevenue += rentalRate * rentalPeriod;
        return rentalRate * rentalPeriod;
    }

    public static int getVehiclesCount() {
        return Vehicle.vehiclesCount;
    }

    public static double getTotalRevenue() {
        return Vehicle.totalRevenue;
    }



    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
}
