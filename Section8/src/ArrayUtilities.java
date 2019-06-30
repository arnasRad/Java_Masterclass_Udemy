import java.util.Random;
import java.util.Scanner;

public class ArrayUtilities {
    private static Scanner scanner = new Scanner(System.in);

    private static int getUserInputInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    public static int[] readIntegers(int count) {
        int[] intArray = new int[count];
        for (int i = 0; i < intArray.length; ++i) {
            System.out.println("Enter " + (i+1) + " number: ");
            intArray[i] = getUserInputInt();
        }

        return intArray;
    }

    public static int[] getRandIntArray(int count, int start, int end) {
        int[] array = new int[count];

        for(int i = 0; i < count; ++i) {
            array[i] = getRandInt(start, end);
        }

        return array;
    }

    public static void printIntArray(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            System.out.println((i+1) + " element of array is: " + array[i]);
        }
        System.out.println();
    }

    private static boolean isSortedAsc(int[] array) {
        for(int i = 0; i < array.length-1; ++i){
            if (array[i] > array[i+1])
                return false;
        }

        return true;
    }

    private static boolean isSortedDesc(int[] array) {
        for(int i = 0; i < array.length-1; ++i){
            if (array[i] < array[i+1])
                return false;
        }

        return true;
    }

    public static void printSortType(int[] array) {
        if (isSortedAsc(array))
            System.out.println("Array sorted ascending");
        else if (isSortedDesc(array))
            System.out.println("Array sorted descending");
        else
            System.out.println("Array is not sorted");

        System.out.println();
    }

    public static void swap(int[] array, int index1, int index2) {
        int tempInt = array[index1];
        array[index1] = array[index2];
        array[index2] = tempInt;
    }

    private static int getRandInt(int a, int b) {
        Random rand = new Random();
        return (rand.nextInt((b - a) + 1) + a);
    }
}
