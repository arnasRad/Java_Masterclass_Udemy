public class WhileDoWhile {
    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0)
            return true;

        return false;
    }

    public static void printEvenNumberInRange(int a, int b) {
        if (a > b) {
            System.out.println("Start of range cannot be greater than end of range");
            return;
        }

        int i = a;
        int evenCount = 0;
        while (i <= b) {
            ++i;
            if(!isEvenNumber(i))
                continue;

            ++evenCount;
            System.out.println("Even number " + i);
            if(evenCount >=5)
                break;
        }

        System.out.println("Even numbers found: " + evenCount);
    }
}
