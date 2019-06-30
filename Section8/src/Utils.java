import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter an integer");
            scanner.nextLine();
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static int getMinutesSecondsInput() {
        int minutes;
        while(true) {
            minutes = getIntInput();
            if (minutes >= 0 && minutes < 60)
                return minutes;
            else
                System.out.println("Input must be in range [0, 60]");
        }
    }

    public static String getStringInput(int expectedLength) {
        if (expectedLength < 1) {
            System.out.println("Expected length of string input must be greater than 0");
            return null;
        }

        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.length() > expectedLength)
                System.out.println("Input length cannot be greater than " + expectedLength);
            else break;
        }
        return input;
    }

    public static String getDoubleAsTime(double number) {
        int intPart = (int) Math.floor(number);
        int decimalPart = (int) Math.round((60*(number-intPart)));
        return(intPart + ":" + decimalPart);
    }

    public static double getTimeAsDouble(int minutes, int seconds) {
        return (double) minutes + ((double) seconds/60);
    }

    public static int getOption(int lastOption) {
        while(true) {
            System.out.println("Enter option: ");
            int option = Utils.getIntInput();
            if (option < 0 || option > lastOption)
                System.out.println("Enter a number between 0 and " + lastOption);
            else
                return option;
        }

    }
    public static Song getCurrentElementListIterator(ListIterator<Song> songs) {
        if (songs.hasNext()) {
            songs.next();
            return songs.previous();
        } else if (songs.hasPrevious()) {
            songs.previous();
            return songs.next();
        }

        return null;
    }

    public static void listAlbums(ArrayList<Album> albums, boolean showSize) {
        int i = 1;
        System.out.println("/************/");
        System.out.println("Albums:");
        for (Album album : albums) {
            if (showSize)
                System.out.println("[" + i + "]: " + album.getName() + ", size: " + album.getSize());
            else
                System.out.println("[" + i + "]: " + album.getName());
            ++i;
        }
        System.out.println("/************/");
        System.out.println();
    }
}
