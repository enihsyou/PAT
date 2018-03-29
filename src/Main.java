import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private static int[] weights = new int[]{
        7,
        9,
        10,
        5,
        8,
        4,
        2,
        1,
        6,
        3,
        7,
        9,
        10,
        5,
        8,
        4,
        2
    };

    private static char[] M = new char[]{
        '1',
        '0',
        'X',
        '9',
        '8',
        '7',
        '6',
        '5',
        '4',
        '3',
        '2'
    };

    private String[] inputs;

    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int size = scanner.nextInt();
        inputs = new String[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = scanner.next();
        }
    }

    public void solve() {
        boolean d = true;
        for (final String input : inputs) {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                final char c = input.charAt(i);
                sum += Character.digit(c, 10) * weights[i];
            }
            if (M[sum % 11] != input.charAt(17)) {
                System.out.println(input);
                d = false;
            }
        }
        if (d) System.out.println("All passed");
    }

    public void output() {

    }

    public void run() {
        input(System.in);
        solve();
        // output();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
