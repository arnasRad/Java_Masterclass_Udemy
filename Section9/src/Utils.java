import java.lang.reflect.Array;
import java.util.*;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(Saveable objectToSave) {
        for(int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

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

    public static int getRandomInteger(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    public static String[] stringToArray(String string, String regex) {
        return string.split(regex);
    }

    public static ArrayList<IntegerNode> getRandomIntegerNodeArray(int size, int minValue, int maxValue) {
        ArrayList<IntegerNode> integerNodes = new ArrayList<>();
        int randomValue;
        for(int i = 0; i < size; ++i) {
            randomValue = getRandomInteger(minValue, maxValue);
            integerNodes.add(new IntegerNode(randomValue));
        }

        return integerNodes;
    }
}
