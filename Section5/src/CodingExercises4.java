public class CodingExercises4 {

    /****************/

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0)
            return false;

        int remainingKilos = goal;
        while(bigCount > 0 && remainingKilos >= 5) {
            remainingKilos -= 5;
            --bigCount;
        }

        while(smallCount > 0 && remainingKilos >= 1) {
            --remainingKilos;
            --smallCount;
        }


        System.out.println("Remaining big count: " + bigCount +
                            ", remaining small count: " + smallCount);


        if(remainingKilos > 0)
            return false;
        else
            return true;
    }

    /****************/

    public static int getLargestPrime(int number) {
        if (number < 2)
            return -1;


        boolean isPrime = true;
        for(int j = 2; j <= number / 2; ++j) {
            if (number % j == 0)
                isPrime = false;
        }
        if (isPrime)
            return number;

        int i = 1;
        int largestPrime = 1;
        int primeNum;
        while(i < number / 2) {
            ++i;
            isPrime = true;
            primeNum = i;
            for(int j = 2; j <= i / 2; ++j) {
                if (i % j == 0)
                    isPrime = false;
            }

            if (isPrime) {
                if (number % primeNum == 0) {
                    largestPrime = primeNum;
                }
            }
        }

        return largestPrime;
    }

    /****************/

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        int i = 0;
        int k;
        while(i < number) {
            k = 0;
            while(k < number) {
                if(i == 0 || i == number - 1 ||
                   k == 0 || k == number - 1 ||
                   i == k || k == (number - i - 1))
                    System.out.print('*');
                else
                    System.out.print(' ');
                ++k;
            }
            System.out.println();
            ++i;
        }
    }
}
