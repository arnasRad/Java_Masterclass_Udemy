public class Main {
    public static void main(String[] args) {
        Utilities utils = new Utilities();
        char[] inputArray = "hello".toCharArray();
        char[] expectedArray = "el".toCharArray();
        int step = 2;
        char[] result = utils.everyNthChar(inputArray, step);
        System.out.println(result);
    }
}
