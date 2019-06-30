import java.util.Scanner;

public class CodingExercises5 {
    /*******/

    public static void inputThenPrintSumAndAverage() {
        Scanner sc = new Scanner(System.in);

        int counter = 0;
        int number = 0;
        int sum = 0;
        int average = 0;
        while(true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sum += number;
            } else {
                if(counter > 0) {
                    if (counter == 1) {
                        average = sum;
                    } else if (sum > 0) {
                        average = sum / counter;
                        if (sum % counter >= counter / 2)
                            ++average;
                    } else {
                        average = sum / counter;
                        if (sum % counter <= -(counter / 2))
                            --average;
                    }
                }
                System.out.println("SUM = " + sum + " AVG = " + average);
                break;
            }

            ++counter;
            sc.nextLine();
        }

        sc.close();
    }

    /************/

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        double totalArea = width * height;
        int bucketsNeeded = (int) Math.ceil(totalArea / areaPerBucket);
//        Double bucketsPrecise = (totalArea / areaPerBucket);
//        int bucketsNeeded = bucketsPrecise.intValue();
//        if (bucketsNeeded < bucketsPrecise) {
//            bucketsNeeded += 1;
//        }

        if(bucketsNeeded > extraBuckets)
            return (bucketsNeeded - extraBuckets);
        else
            return 0;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        return getBucketCount(area,1,areaPerBucket);
    }
}
