public class CodingExercises3 {
    /*******************/

    public static boolean isPalindrome(int number) {
        int reverse = 0;

        int num = number;
        int lastDigit;
        while (Math.abs(num) > 0) {
            lastDigit = num % 10;
            reverse = reverse * 10;
            reverse += lastDigit;
            num /= 10;
        }

        if (reverse == number)
            return true;
        return false;
    }

    /*******************/

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0)
            return -1;

        int firstDigit = number % 10;
        int lastDigit = 0;
        while(number > 0) {
            lastDigit = number % 10;
            number /= 10;
        }

        return (firstDigit + lastDigit);
    }

    /*******************/

    public static int getEvenDigitSum(int number) {
        if (number < 0)
            return -1;

        int sum = 0;
        int lastDigit = 0;
        while(number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 == 0)
                sum += lastDigit;

            number /= 10;
        }

        return sum;
    }

    /*******************/

    public static boolean hasSharedDigit(int a, int b) {
        if (a < 10 || a > 99 || b < 10 || b > 99)
            return false;

        int tempNum;
        int aDigit;
        while(a > 0) {
            tempNum = b;
            aDigit = a % 10;
            while(tempNum > 0) {
                if (tempNum % 10 == aDigit)
                    return true;

                tempNum /= 10;
            }

            a /= 10;
        }

        return false;
    }

    /*******************/

    public static boolean hasSameLastDigit(int x, int y, int z) {
        if (x < 10 || x > 1000 ||
            y < 10 || y > 1000 ||
            z < 10 || z > 1000)
            return false;

        int xRightmost = x % 10;
        int yRightmost = y % 10;
        int zRightmost = z % 10;

        return xRightmost == yRightmost ||
                xRightmost == zRightmost ||
                yRightmost == zRightmost;
    }

    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }

    /*******************/

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10)
            return -1;

        int minimum;
        int maximum;
        if (first <= second) {
            minimum = first;
            maximum = second;
        } else {
            minimum = second;
            maximum = first;
        }

        int i = 2;
        int GCD = 1;
        while (i <= minimum) {
            if (minimum % i == 0 && maximum % i == 0)
                GCD = i;

            if(i >= minimum/2 && i < minimum)
                i = minimum;
            else
                ++i;
        }

        return GCD;
    }

    /*******************/

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        int i = 1;
        while (i <= number) {
            if(number % i == 0)
                System.out.print(i + " ");

            ++i;
        }

    }

    /*******************/

    public static boolean isPerfectNumber(int number) {
        if (number < 1)
            return false;

        // get the sum of proper divisors
        int sum = 0;
        int i = 1;
        while(i < number) {
            if (number % i == 0)
                sum += i;

            ++i;
        }

        if (sum == number)
            return true;

        return false;
    }

    public static void printPerfectNumbersInRange(int a, int b) {
        if (a < 0 || b < 0 || a > b) {
            System.out.println("Invalid Arguments");
            return;
        }

        while(a <= b) {
            if (isPerfectNumber(a))
                System.out.println(a + " is a perfect number");

            ++a;
        }
    }

    /*******************/

    public static void numberToWords(int number) {
        if (number < 0)
            System.out.println("Invalid Value");
        else if (number == 0)
            System.out.println("Zero");

        int lastDigit;
        String numberAsWords = "";
        int reversed = reverse(number);
        int numDigitCount = getDigitCount(number);
        int reverseNumDigitCount = getDigitCount(reversed);
        while(reversed > 0) {
            lastDigit = reversed % 10;

            switch (lastDigit) {
                case 0:
                    numberAsWords += "Zero ";
                    break;
                case 1:
                    numberAsWords += "One ";
                    break;
                case 2:
                    numberAsWords += "Two ";
                    break;
                case 3:
                    numberAsWords += "Three ";
                    break;
                case 4:
                    numberAsWords += "Four ";
                    break;
                case 5:
                    numberAsWords += "Five ";
                    break;
                case 6:
                    numberAsWords += "Six ";
                    break;
                case 7:
                    numberAsWords += "Seven ";
                    break;
                case 8:
                    numberAsWords += "Eight ";
                    break;
                case 9:
                    numberAsWords += "Nine ";
                    break;
            }

            reversed /= 10;
        }

        if (numDigitCount > reverseNumDigitCount) {
            for(int i = reverseNumDigitCount; i < numDigitCount; ++i) {
                numberAsWords += "Zero ";
            }
        }

        System.out.println(numberAsWords);
    }

    public static int reverse(int number) {
        int reversed = 0;
        if (number > 0) {
            while (number > 0) {
                reversed += number % 10;
                reversed *= 10;
                number /= 10;
            }
        } else {
            while (number < 0) {
                reversed += number % 10;
                reversed *= 10;
                number /= 10;
            }
        }

        reversed /= 10;
        return reversed;
    }

    public static int getDigitCount(int number) {
        if (number < 0)
            return -1;

        int i = 0;
        while (number >= 0) {
            ++i;
            number /= 10;
        }

        return i;
    }
}
