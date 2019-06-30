import java.util.Scanner;

public class Main {
    public static Scanner x = new Scanner(System.in);
    public static void main(String[] args) {
        (new X(new Scanner(System.in))).x();
    }
}


class X {
    private int x;
    X(Scanner x) {
        System.out.println("Enter x: ");
        this.x = x.nextInt();
    }

    public void x() {
        for(int x = 1; x <= this.x; ++x) {
            System.out.println(x + " times 2 equals " + x * 2);
        }
    }
}