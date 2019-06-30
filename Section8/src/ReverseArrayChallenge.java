public class ReverseArrayChallenge {
    public static void reverse(int[] array) {
        for(int i = 0; i < array.length/2; ++i) {
            ArrayUtilities.swap(array, i, array.length - i - 1);
        }
    }

    public static boolean isReverse(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            System.out.println("Arrays are not the same size");
            return false;
        }

        for(int i = 0; i < array1.length; ++i) {
            if (array1[i] != array2[array2.length - i - 1]) {
                System.out.println("Arrays are not reversed");
                return false;
            }
        }

        System.out.println("Arrays are reversed");
        return true;
    }
}
