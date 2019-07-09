import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

//        System.out.println();
//        System.out.println("Employees over 30:");
//        System.out.println("===========================");
//        employees.forEach(employee -> {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//        System.out.println("Employees less or equal to 30:");
//        System.out.println("===========================");
//        employees.forEach(employee -> {
//            if(employee.getAge() <= 30) {
//                System.out.println(employee.getName());
//            }
//        });

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);

//        for(Employee employee : employees) {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        }
//        employees.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println("===========================");
        System.out.println(ageText);
        System.out.println("===========================");
        for(Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
