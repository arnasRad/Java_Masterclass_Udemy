import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // #1
        printChallengeNo(1);
        String challenge1 = "I want a bike.";
        String regex = "^I want a bike\\.$";
        System.out.println(challenge1.matches(regex));

        // #2
        printChallengeNo(2);
        regex = "^I want a (bike|ball)\\.$";
        String challenge2 = "I want a ball.";
        String challenge2dummy = "I want a dummy";
        System.out.println(challenge1.matches(regex));
        System.out.println(challenge2.matches(regex));
        System.out.println(challenge2dummy.matches(regex));

        // #3
        printChallengeNo(3);
        Pattern challenge2Pattern = Pattern.compile(regex);
        System.out.println(challenge2Pattern.matcher(challenge1).matches());
        System.out.println(challenge2Pattern.matcher(challenge2).matches());

        // #4
        printChallengeNo(4);
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        // #5
        printChallengeNo(5);
        String challenge5 = "aaabccccccccdddefffg";
        regex = "[abcdefg]+";
        System.out.println(challenge5.matches(regex));
        regex = "[a-g]+";
        System.out.println(challenge5.matches(regex));

        // #6
        printChallengeNo(6);
        regex = "a{3}bc{8}d{3}ef{3}g";
        System.out.println(challenge5.matches(regex));

        // #7
        printChallengeNo(7);
        String challenge7 = "abcd.135";
        regex = "^[a-zA-Z]+\\.\\d+$";
        System.out.println(challenge7.matches(regex));
    }

    private static void printChallengeNo(int challengeNo) {
        System.out.println();
        System.out.format("********* CHALLENGE %d *********\n", challengeNo);
    }
}
