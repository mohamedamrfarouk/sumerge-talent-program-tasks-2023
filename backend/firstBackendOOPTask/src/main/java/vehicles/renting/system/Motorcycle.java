package vehicles.renting.system;

public class Motorcycle extends Vehicle {
    private int engineCapacity;
    private static int motorcyclesCount=0;
    private static int motorcyclesRevenue=0;

    Motorcycle(int registrationNumber, String brand, int year,  int engineCapacity){
        super(registrationNumber, brand, year, "vehicles.renting.system.motorcycle",1.5);
        this.engineCapacity = engineCapacity;
        Motorcycle.motorcyclesCount++;
    }
    public double  calculateRentalCost(int rentalPeriod){
        Vehicle.totalRevenue += super.rentalRate * rentalPeriod;
        Motorcycle.motorcyclesRevenue += super.rentalRate * rentalPeriod;

        return super.rentalRate * rentalPeriod;
    }
    public static int getBicyclesCount() {
        return motorcyclesCount;
    }

    public static int getMotorcyclesRevenue() {
        return motorcyclesRevenue;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

}
