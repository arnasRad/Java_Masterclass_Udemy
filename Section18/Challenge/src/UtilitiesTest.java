import jdk.swing.interop.SwingInterOpUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class UtilitiesTest {
    Utilities utils = new Utilities();

    @BeforeClass
    public static void initialize() {

    }

    @Test
    public void everyNthChar() {
        fail("This test has not been implemented");
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
    public void converter() {
        fail("This test has not been implemented");
    }

    @Test
    public void nullIfOddLength() {
        fail("This test has not been implemented");
    }
}