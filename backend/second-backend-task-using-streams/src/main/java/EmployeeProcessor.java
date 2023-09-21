import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProcessor {

    public static List<Employee> employeesList = new ArrayList<>( Arrays.asList(
            new Employee(1, "Mohamed", "dev", 10),
            new Employee(2, "Amr", "dev", 15),
            new Employee(3, "Farouk", "dev", 20),
            new Employee(4, "Ebrahim", "dev", 25),
            new Employee(5, "Ahmed", "support", 30),
            new Employee(6, "Elsayed", "suport", 35),
            new Employee(7, "abdelrahman", "suport", 40),
            new Employee(8, "shady", "leader", 45),
            new Employee(9, "nour", "leader", 50),
            new Employee(10, "Yomna", "leader", 55),
            new Employee(11, "anwar", "sales", 60),
            new Employee(12, "joe", "sales", 65),
            new Employee(13, "reda", "sales", 70)
    ));

    public static List<Employee> getEmployeesInDepartment(List<Employee>employees, String department){
        List<Employee> myFilteredEmployees = employees.stream()
                                                    .filter(e->e.getDepartment().equals(department))
                                                    .collect(Collectors.toList());


        return myFilteredEmployees;
    }
    public static List<String> getEmployeesNames(List<Employee>employees){
        List<String> namesList = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        return namesList;
    }
    public static double getSalarySum(List<Employee>employees){
        double sum = employees.stream().mapToDouble(e->e.getSalary()).sum();

        return sum;
    }
    public static List<Employee> getIncrementedEmployeesSalaries(List<Employee>employees, double incrementPercentage){
        List<Employee> myNewEmployees = employees;
        myNewEmployees.forEach(employee -> employee.setSalary(employee.getSalary()*(1+incrementPercentage)));

        return  myNewEmployees;
    }

    public static void main(String[] args) {
        getEmployeesInDepartment( employeesList, "dev").
                forEach(e-> System.out.println(e));

        System.out.println();
        System.out.println();

        System.out.println("salaries Sum: "+ getSalarySum(employeesList));

        System.out.println();
        System.out.println();

        getEmployeesNames(employeesList).forEach(n-> System.out.println(n));

        System.out.println();
        System.out.println();

        getIncrementedEmployeesSalaries(employeesList, 0.2538)
                .forEach(e-> System.out.println(e));
    }


}
