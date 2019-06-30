import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void UserMinAndMax() {
        Scanner sc = new Scanner(System.in);

        int counter = 0;
        int min = 0;
        int max = 0;
        int number;
        while(true) {
            System.out.println("Enter " + (counter + 1) + " number: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (counter == 0) {
                    min = number;
                    max = number;
                } else {
                    if (number > max)
                        max = number;
                    if (number < min)
                        min = number;
                }
            } else {
                break;
            }

            sc.nextLine();
            ++counter;
        }
        System.out.println("Max value: " + max + ", min value: " + min);

        sc.close();
    }
}
