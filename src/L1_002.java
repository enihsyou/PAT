import java.util.Scanner;

public class L1_002 {

    public static void main(String[] args) {
        long size;
        String placeholder;
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextLong();
        placeholder = scanner.next();
        int tiers = (int) Math.sqrt((size + 1) / 2.0); // level
        int line = 2 * tiers - 1; // characters per level

        for (int i = 0; i < tiers; i++) {
            repeat(" ", i);
            repeat(placeholder, line - 2 * i);
            System.out.println();
        }
        for (int i = (tiers - 1) - 1; i >= 0; i--) {
            repeat(" ", i);
            repeat(placeholder, line - 2 * i);
            System.out.println();
        }
        System.out.println(size - (tiers * tiers * 2 - 1));
    }

    static void repeat(String placeholder, int times) {
        while (times > 0) {
            System.out.print(placeholder);
            times--;
        }
    }
}
