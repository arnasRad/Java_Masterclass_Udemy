import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    Utilities utils = new Utilities();

    @BeforeClass
    public static void initialize() {

    }

    @Test
    public void everyNthChar() {
        char[] inputArray = "hello".toCharArray();
        char[] expectedArray = "el".toCharArray();
        int step = 2;
        char[] result = utils.everyNthChar(inputArray, step);
        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void everyNthCharLengthGreater() {
        char[] inputArray = "hello".toCharArray();
        int step = inputArray.length+1;
        char[] result = utils.everyNthChar(inputArray, step);
        assertArrayEquals(inputArray, result);
    }

    @Test
    public void removePairs1() {
        String input = "AABCDDEFF";
        String expected = "ABCDEF";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairs2() {
        String input = "ABCCABDEEF";
        String expected = "ABCABDEF";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairs3() {
        String input = "ABCCABDEE";
        String expected = "ABCABDE";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairs4() {
        String input = "ABCCCABDEE";
        String expected = "ABCCABDE";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairs5() {
        String input = "ABCCCCABDEE";
        String expected = "ABCCABDE";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairsNull() {
        String input = null;
        String expected = "ABCCABDE";
        String result = utils.removePairs(input);
        assertNull("Did not get null returned when argument passed was null", result);
    }

    @Test
    public void removePairsLengthLessTwo() {
        String input = "A";
        String expected = "A";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void removePairsEmpty() {
        String input = "";
        String expected = "";
        String result = utils.removePairs(input);
        assertEquals(expected, result);
    }

    @Test
    public void converter() {
        int a = 10;
        int b = 5;
        int expected = 300;
        int result = utils.converter(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void nullIfOddLength_Null() {
        String input = null;
        String result = utils.nullIfOddLength(input);
        assertNull(result);
    }

    @Test
    public void nullIfOddLength_Even() {
        String input = "abcd";
        String result = utils.nullIfOddLength(input);
        assertNotNull(result);
    }

    @Test
    public void nullIfOddLength_Odd() {
        String input = "abc";
        String result = utils.nullIfOddLength(input);
        assertNull(result);
    }
}