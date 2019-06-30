
public class MinElementChallenge {
    public static int getMinIntegerFromInput(int count) {
        int[] array = ArrayUtilities.readIntegers(count);
        return(getMin(array));
    }

    public static int getMin(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; ++i) {
            if (array[i] < min)
                min = array[i];
        }

        return min;
    }
}
