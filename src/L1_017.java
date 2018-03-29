import java.io.InputStream;
import java.util.Scanner;

public class L1_017 extends TestAlgorithm {

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

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int size = scanner.nextInt();
        inputs = new String[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = scanner.next();
        }
    }

    @Override
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

    @Override
    public void output() {

    }

    @Override
    public void run() {
        input(System.in);
        // solve();
        // output();
    }

    @Override
    public String[] setTestCases() {
        return new String[]{
            "4\n" +
            "320124198808240056\n" +
            "12010X198901011234\n" +
            "110108196711301866\n" +
            "37070419881216001X",
            "2\n" +
            "320124198808240056\n" +
            "110108196711301862"
        };
    }

    public static void main(String[] args) {
        new L1_017().test();
    }
}
