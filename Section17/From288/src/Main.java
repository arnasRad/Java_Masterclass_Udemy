import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijk199z";
        System.out.println();
        System.out.println(alphanumeric);
        System.out.println(alphanumeric.replaceAll(".", "Y")); // '.' - character class (any character)

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondAlphanumeric = "abcDeeeF12GabcDeeehhiiiijk199z";
        System.out.println(secondAlphanumeric.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello")); // doesn't match -> false
        System.out.println(alphanumeric.matches("^abcDeee")); // false, because string needs to match as a whole
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijk199z")); // true, because the whole string matches

        System.out.println();
        System.out.println(alphanumeric.replaceAll("jk199z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X")); // replace letters a, e and i with X
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        // replace letters a, e and i with X only if they are followed by F or j
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println();
        // replaced to sentence case
        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        // replace every letter except e and j
        System.out.println(alphanumeric.replaceAll("[^ej]", "X")); // [^*] ^ negates the pattern that follows it

        // '-' specifies a range
        System.out.println(alphanumeric.replaceAll("[abcdef34578]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));

        // turn off case sensitivity with special construct '(?i)'; (?iu) - unicode
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        System.out.println();
        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(alphanumeric.replaceAll("[\\d]", "X")); // replace all digits
        System.out.println(alphanumeric.replaceAll("[\\D]", "X")); // replace all non-digits

        System.out.println();
        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", "")); // remove whitespaces, tabs, newlines etc..
        System.out.println(hasWhitespace.replaceAll("\t", "")); // remove tab
        System.out.println(hasWhitespace.replaceAll("\\S", "X"));

        System.out.println();
        // replace non-whitespace characters
        System.out.println(alphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));

        // \\b matches word boundaries (use example - surround each word with some tag etc)
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));


        // Video 290
        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijk199z";
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));  // exactly 3 e's
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY")); // one or more e's
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));  // none or any number of e's
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY")); // 2 to 5 e's
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "Y"));

        // Pattern and Matcher
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = "<h2>"; // there can be anything before and anything after the <h2> tags
        Pattern pattern = Pattern.compile(h2Pattern);
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); // case insensitive and unicode case pattern
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset(); // matchers can only be used once!
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

//        String h2GroupPattern = "(<h2>.*</h2>)";
        // '?' turn greedy quantifier into a lazy quantifier -> stops at the first occurrence of </h2>
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.*?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence " + h2TextMatcher.group(2));
        }
    }
}
