import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* #1 */
//        new Thread(new CodeToRun()).start();

        /* #2 */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        /* #3 */
//        new Thread(() -> System.out.println("Printing from the Runnable")).start();

        /* #4 */
//        new Thread(() -> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Hello again");
//        }).start();

        /* #5 */
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName())
//        );

        // possible to leave-out parapeter types if they're the same
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName())
        );

        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println();

        /* #6 */
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String uperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        /* #7 */
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc,
                employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.uperAndConcat(s1, s2);
    }
}

//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable");
//    }
//}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String uperAndConcat(String s1, String s2);
}