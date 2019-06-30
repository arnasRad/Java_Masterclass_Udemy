public class CodingExercises1 {
    public static void printNumberInWord(int number) {
        switch (number) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999)
            return false;
        else if (year % 4 == 0) {
            if(year % 100 == 0) {
                if (year % 400 == 0) {
                    return(true);
                }
            } else {
                return(true);
            }
        }
        return(false);
    }

    public static int getDaysInMonth(int month, int year) {
        if(month < 1 || month > 12 || year < 1 || year > 9999)
            return -1;

        switch (month) {
            case 1:
                return(31);
            case 2:
                if (isLeapYear(year))
                    return(29);
                else
                    return(28);
            case 3:
                return(31);
            case 4:
                return(30);
            case 5:
                return(31);
            case 6:
                return(30);
            case 7:
                return(31);
            case 8:
                return(31);
            case 9:
                return(30);
            case 10:
                return(31);
            case 11:
                return(30);
            case 12:
                return(31);
            default:
                return -1;
        }
    }
}
