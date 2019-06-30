public class ThreeAndFiveChallenge {
    public static boolean printUpToFiveDiv(int a, int b) {
        int divisionCount = 0;
        int sum = 0;
        for(int i = a; i < b; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                ++divisionCount;
                sum += i;
                System.out.println(i + " can be divided by both 3 and 5");
            }

            if (divisionCount >= 5) {
                System.out.println( "At least five numbers can be " +
                                    "divided by both 3 and 5 in given range (" +
                                    a + "," + b + "). Sum of these numbers: " +
                                    sum);
                return true;
            }
        }
        System.out.println( "There are less than five numbers that can be " +
                            "divided by both 3 and 5 in given range (" +
                            a + "," + b + ").");

        return false;
    }
}
