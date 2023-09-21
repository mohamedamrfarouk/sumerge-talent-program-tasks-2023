package vehicles.renting.system;

public class Bicycle extends Vehicle {
    private static int bicyclesCount=0;
    private static int bicyclesRevenue=0;

    Bicycle(int registrationNumber, String brand, int year){
        super(registrationNumber, brand, year, "vehicles.renting.system.bicycle",1.0);
        Bicycle.bicyclesCount++;
    }

    public double  calculateRentalCost(int rentalPeriod){
        Vehicle.totalRevenue += super.rentalRate * rentalPeriod;
        Bicycle.bicyclesRevenue += super.rentalRate * rentalPeriod;

        return super.rentalRate * rentalPeriod;
    }

    public static int getBicyclesCount() {
        return bicyclesCount;
    }

    public static int getBicyclesRevenue() {
        return bicyclesRevenue;
    }

}
