package vehicles.renting.system;

public class Car extends Vehicle {
    private String fuelType;
    private static int carsCount=0;
    private static int carsRevenue=0;


    Car(int registrationNumber, String brand, int year, String fuelType){
        super(registrationNumber, brand, year, "vehicles.renting.system.car",2.0);
        this.fuelType = fuelType;
        Car.carsCount++;
    }
    @Override
    public double  calculateRentalCost(int rentalPeriod){
        Vehicle.totalRevenue += super.rentalRate * rentalPeriod;
        Car.carsRevenue += super.rentalRate * rentalPeriod;
        return super.rentalRate * rentalPeriod;
    }

    public static int getCarsCount() {
        return carsCount;
    }

    public static int getCarsRevenue() {
        return carsRevenue;
    }



    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

}
