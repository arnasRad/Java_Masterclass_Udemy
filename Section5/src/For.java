public class For {
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for(int i = 2; i <= (long) Math.sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static boolean moreThanThreePrimeNumbers(int k, int l) {
        int primeCount = 0;
        for (; k <= l; ++k) {
            if (isPrime(k)) {
                System.out.println(k + " is a prime number");
                ++primeCount;
            }

            if (primeCount >= 3) {
                System.out.println("More than three prime numbers found! Terminating loop...");
                return true;
            }
        }

        return false;
    }
}
