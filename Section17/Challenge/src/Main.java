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

        // #8
        printChallengeNo(8);
        String challenge8 = "abcd.135uvqz.7tzik.999";
        regex = "[a-zA-Z]+\\.(\\d+)";
        Pattern challenge8Pattern = Pattern.compile(regex);
        Matcher challenge8Matcher = challenge8Pattern.matcher(challenge8);
        while(challenge8Matcher.find()) {
            System.out.println(challenge8Matcher.group(1)); // group(0) -> entire string
        }

        // #9
        printChallengeNo(9);
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        regex = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern challenge9Pattern = Pattern.compile(regex);
        Matcher challenge9Matcher = challenge9Pattern.matcher(challenge9);
        while(challenge9Matcher.find()) {
            System.out.println(challenge9Matcher.group(1));
        }

        // #10
        challenge9Matcher.reset();
        while(challenge9Matcher.find()) {
            System.out.println("Occurrence: " + challenge9Matcher.group(1) + ", start: "
                    + challenge9Matcher.start(1)
                    + ", end: " + (challenge9Matcher.end(1) - 1));
        }

        // #11
        printChallengeNo(11);
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x,y}";
        regex = "\\{(\\d+[ ]*,[ ]*\\d+)\\}";
        Pattern challenge11Pattern = Pattern.compile(regex);
        Matcher challenge11Matcher = challenge11Pattern.matcher(challenge11);
        while(challenge11Matcher.find()) {
            System.out.println(challenge11Matcher.group(1));
        }

        // #12
        printChallengeNo(12);
        String challenge12 = "11111";
        regex = "^\\d{5}$";
        Pattern challenge12Pattern = Pattern.compile(regex);
        Matcher challenge12Matcher = challenge12Pattern.matcher(challenge12);
        System.out.println(challenge12Matcher.matches());

        // #13
        printChallengeNo(13);
        String challenge13 = "11111-1111";
        regex = "^\\d{5}-\\d{4}$";
        Pattern challenge13Pattern = Pattern.compile(regex);
        Matcher challenge13Matcher = challenge13Pattern.matcher(challenge13);
        System.out.println(challenge13Matcher.matches());

        // #14
        printChallengeNo(14);
        String challenge14 = "11111-1111";
        regex = "^\\d{5}(-\\d{4})?$";
        Pattern challenge14Pattern = Pattern.compile(regex);
        Matcher challenge14Matcher = challenge14Pattern.matcher(challenge14);
        System.out.println(challenge14Matcher.matches());

    }

    private static void printChallengeNo(int challengeNo) {
        System.out.println();
        System.out.format("********* CHALLENGE %d *********\n", challengeNo);
    }
}
