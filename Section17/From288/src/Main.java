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
    }
}
