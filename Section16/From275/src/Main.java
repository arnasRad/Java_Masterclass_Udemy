import java.util.ArrayList;
import java.util.Collections;
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
//        Employee john = new Employee("John Doe", 30);
//        Employee tim = new Employee("Tim Buchalka", 21);
//        Employee jack = new Employee("Jack Hill", 40);
//        Employee snow = new Employee("Snow White", 22);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(john);
//        employees.add(tim);
//        employees.add(jack);
//        employees.add(snow);

//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName())
//        );

        // possible to leave-out parapeter types if they're the same
//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName())
//        );
//
//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//        System.out.println();

        /* #6 */
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        /* #7 */
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        String sillyString = doStringStuff(uc,
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        /* #8 */
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        String sillyString = doStringStuff(uc,
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//        System.out.println();

        /* #9 */
//        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);

        /* #10 */
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        for (Employee employee : employees) {
            // in foreach loop a new employee variable is created on each iteration
            // and therefore is effectively final
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

//        System.out.println();
//
////        Employee employee; // this would not work in a loop
//        for(int i = 0; i < employees.size(); ++i) {
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

        /* 11 */
        System.out.println();
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
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
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
//        UpperConcat uc = (s1, s2) -> {
//            /* lambda is not an anonymous class. Expression is treated as a nested block of code
//            and has the same scope as the nested block */
//            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };

//        final int i = 0;
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("i (within anonymous class) + " + i); // i needs to be final
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//            System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//
////            ++i;
//            System.out.println("i = " + i);
//            return Main.doStringStuff(uc, "String1", "String2");
//        }

        int i = 0; // effectively final variable
//        ++i;  // cancels effectively final modifier
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

//        s1 = "Hello"; // does not work

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");


//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(uc, "String1", "String2");

//        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}