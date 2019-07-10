import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // #1
        printSeparator(1);
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts) {
                System.out.println(part);
            }
        };
        runnable.run();

        // #2
        printSeparator(2);
        Function<String, String> lambdaFunction = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); ++i) {
                if (i%2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // #3
        printSeparator(3);
        System.out.println(lambdaFunction.apply("1234567890"));

        // #4-5
        printSeparator(4);
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        // #6
        printSeparator(6);
        Supplier<String> supplierExpression = () -> "I love Java!";

        // #7
        String supplierResult = supplierExpression.get() ;
        System.out.println(supplierResult);

        // #8
        printSeparator(8);
        System.out.println("Q: What criteria must be met to map a lambda expression to a specific interface?");
        System.out.println("A: Interface must have only one method to implement (it has to be a functional interface");

        System.out.println();
        System.out.println("Q: Can we use a lambda expression to represent an instance of the " +
                            "java.util.concurrent.Callable interface? Hint: check the documentation");
        System.out.println("A: Yes, we can, because this interface only has one method to implement - call()." +
                            " It is a functional interface. Java documentation states that, too.");

        System.out.println();
        System.out.println("Q: Is the java.util.Comparator interface a functional interface?");
        System.out.println("A: Yes, it is. Only one of ten methods need to be implemented - compare()");

        // #9
        printSeparator(9);
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        Function<String, String> toSentenceCase = (String s) -> {
            String uppercaseFirstChar = s.substring(0, 1).toUpperCase();
            return uppercaseFirstChar.concat(s.substring(1));
        };
        Consumer<List<String>> sortList = list -> {
            Collections.sort(list, (s1, s2) ->
                s1.compareTo(s2)
            );
        };
        Function<List<String>, List<String>> toSentenceCaseList = list -> {
            List<String> sentenceCaseList = new ArrayList<>();
            list.forEach(s -> {
                sentenceCaseList.add(toSentenceCase.apply(s));
            });
            return sentenceCaseList;
        };

        List<String> sentenceCaseList = toSentenceCaseList.apply(topNames2015);
        sortList.accept(sentenceCaseList);
        sentenceCaseList.forEach(System.out::println); // method reference

        // #10
        printSeparator(10);

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        // #11
        printSeparator(11);
        topNames2015.stream()
                .map(toSentenceCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // #12
        printSeparator(12);
        System.out.println("The number of names that starts with a letter 'A': " +
                topNames2015.stream()
                .map(toSentenceCase)
                .filter(s -> s.startsWith("A"))
                .count());

        // #13
        printSeparator(13);
        System.out.println("Q: What will the following code print to the console? " +
                "(reference video 287, 13:30)");
        System.out.println("A: it will print nothing, because there is no terminal operation");

        // #14
        printSeparator(14);
        // 1.
//        topNames2015
//                .stream()
//                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
//                .peek(System.out::println)
//                .sorted(String::compareTo)
//                .forEach(s -> {});
        // 2.
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());


    }

    private static String everySecondCharacter(Function<String, String> function, String fArg) {
        return function.apply(fArg);
    }

    private static void printSeparator(int challengeNo) {
        System.out.println();
        System.out.format("******* CHALLENGE # %d *******\n", challengeNo);
    }
}
