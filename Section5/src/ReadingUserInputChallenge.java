import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void SumOfUserInputNumbers(int count) {
        int i = 0;
        int number = 0;
        int sum = 0;
        Scanner s = new Scanner(System.in);
        while (i < count) {
            System.out.println("Enter #" + (i + 1) + " number: ");
            while(!s.hasNextInt()) {
                System.out.println("Invalid number. Enter an integer: ");
                s.next();
            }

            number = s.nextInt();
            sum += number;
            ++i;
        }
        s.close();
        System.out.println("Sum of numbers: " + sum);
    }
}
