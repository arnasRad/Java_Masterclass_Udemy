public class Switch {
    public static void testSwitchChar(char character) {
        switch(character) {
            case 'A':
                System.out.println("Character was A");
                break;
            case 'B':
                System.out.println("Character was B");
                break;
            case 'C': case 'D': case 'E':
                System.out.println("Character was " + character);
                break;
            default:
                System.out.println("Character was neither A, B, C, D or E");
                break;
        }
    }

    public static void testSwitchString(String text) {
        switch (text.toLowerCase()) {
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break;
        }
    }
}
