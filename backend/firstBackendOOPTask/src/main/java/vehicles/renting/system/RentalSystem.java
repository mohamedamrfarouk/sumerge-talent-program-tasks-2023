package vehicles.renting.system;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private static List<Vehicle> availableVehicles = new ArrayList<>(Arrays.asList(
            new Car(1, "toyota", 2001, "benzine"),
            new Car(2, "kia", 2002, "benzine"),
            new Car(3, "MG", 2003, "benzine"),
            new Car(4, "suzuki", 2004, "benzine"),
            new Bicycle(5, "bike1", 2001),
            new Bicycle(6, "bike2", 2002),
            new Bicycle(7, "bike3", 2003),
            new Bicycle(8, "bike4", 2004),
            new Motorcycle(9, "Motorcycle1", 2001, 10),
            new Motorcycle(10, "Motorcycle2", 2002, 20),
            new Motorcycle(11, "Motorcycle3", 2003, 30),
            new Motorcycle(2, "Motorcycle4", 2004, 40)
    )) ;
    private static List<Vehicle> rentedVehicles = new ArrayList<>();

    public static double rentVehicle(int registrationNumber, int rentalPeriod){
        Vehicle myVehicle= availableVehicles.stream().filter(v->v.getRegistrationNumber() == registrationNumber).findFirst().orElse(null);
        if(myVehicle == null) {
            System.out.println("this vehicle is not available \n");
            return 0.0;
        }

        availableVehicles.remove(myVehicle);
        rentedVehicles.add(myVehicle);

        double rentalCost = myVehicle.calculateRentalCost(rentalPeriod);
        myVehicle.setRented(true);
        System.out.printf("%n registration number: %s %n brand: %s %n year: %s %n type: %s %n" ,
                            myVehicle.getRegistrationNumber(),
                            myVehicle.getBrand(),
                            myVehicle.getYear(),
                            myVehicle.getType());
        System.out.printf(" rented with cost: %s. %n", rentalCost);

        if(myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle;
            System.out.printf(" type: car %n Fuel Type: %s %n%n", myCar.getFuelType());
        }
        else if(myVehicle instanceof Motorcycle) {
            Motorcycle myMotorcycle = (Motorcycle) myVehicle;
            System.out.printf(" type: Motorcycle %n Engine Capacity: %s %n%n", myMotorcycle.getEngineCapacity());
        }
        else{
            System.out.println(" type: Bicycle \n");
        }
        return rentalCost;
    }

    public static void getTotalRentalRevenue(){
        System.out.printf("%nThe Total Cars Revenue Till Now: %s$ %n", Car.getCarsRevenue());
        System.out.printf("%nThe Total Bicycles Revenue Till Now: %s$ %n", Bicycle.getBicyclesRevenue());
        System.out.printf("%nThe Total Motorcycle Revenue Till Now: %s$ %n", Motorcycle.getMotorcyclesRevenue());

        System.out.printf("%nThe Total Revenue of all Vehicles Till Now: %s$ %n%n", Vehicle.getTotalRevenue());

    }

    public static void returnVehicle(int registrationNumber){
        Vehicle myRentedVehicle= rentedVehicles.stream().filter(v->v.getRegistrationNumber() == registrationNumber).findFirst().orElse(null);
        if(myRentedVehicle == null) {
            System.out.println("this vehicle is not available in rented vehicles \n");
        }

        rentedVehicles.remove(myRentedVehicle);
        availableVehicles.add(myRentedVehicle);

        myRentedVehicle.setRented(false);
        System.out.printf(" registration number: %s %n brand: %s %n year: %s %n type: %s %n" ,
                            myRentedVehicle.getRegistrationNumber(),myRentedVehicle.getBrand(),
                            myRentedVehicle.getYear(), myRentedVehicle.getType());

        System.out.println("you successfully returned this vehicle. \n");


    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.printf("%nchoose between the following options: %n");
            System.out.printf(" 1. rent car %n 2. return car %n 3. see total revenue %n");
            System.out.print("your choice: ");

            int option = sc.nextInt();
            if(option==1) {
                System.out.print("enter registration number: ");
                int regNumber = sc.nextInt();

                System.out.print("enter rental period: ");
                int rentalPeriod = sc.nextInt();

                RentalSystem.rentVehicle(regNumber, rentalPeriod);

            }else if(option==2){
                System.out.print("enter registration number: ");
                int regNumber = sc.nextInt();

                RentalSystem.returnVehicle(regNumber);

            }else if(option==3){
                RentalSystem.getTotalRentalRevenue();

            }else{
                System.out.printf("invalid option please ");
                continue;
            }

            System.out.print("do you wanna do any thing else [yes:y,No:any thing else]: ");
            char c = sc.next().charAt(0);
            if(c == 'y'){continue;}
            else {break;}
        }
    }
}

