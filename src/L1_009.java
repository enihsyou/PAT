import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class L1_009 extends TestAlgorithm {

    private static final Pattern COMPILE = Pattern.compile("/");

    private int inputSize;

    private long[] numerators;

    private long[] denominators;

    private long a, b = 1;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        inputSize = scanner.nextInt();
        numerators = new long[inputSize];
        denominators = new long[inputSize];
        for (int i = 0; i < inputSize; i++) {
            final String[] next = COMPILE.split(scanner.next());
            numerators[i] = Long.parseLong(next[0]);
            denominators[i] = Long.parseLong(next[1]);
        }
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        long a1, b1;
        while (b != 0) {
            a1 = a;
            b1 = b;
            a = b1;
            b = a1 % b1;
        }
        return a;
    }

    @Override
    public void solve() {
        if (denominators.length < 1) return;
        long numerator1 = numerators[0];
        long denominator1 = denominators[0];
        for (int i = 1; i < denominators.length; i++) {
            long gcd = gcd(denominator1, denominators[i]);
            long lcm = denominator1 / gcd * denominators[i];
            long scale_1 = lcm / denominator1;
            long scale_2 = lcm / denominators[i];
            numerator1 = scale_1 * numerator1 + scale_2 * numerators[i];
            denominator1 = lcm;
            if (numerator1 == 0) {
                denominator1 = 1;
            } else {
                gcd = gcd(numerator1, denominator1);
                numerator1 /= gcd;
                denominator1 /= gcd;
            }
        }
        a = numerator1;
        b = denominator1;
    }

    @Override
    public void output() {
        long q1 = a / b;
        long q2 = a - q1 * b;
        if (q1 == 0 && q2 == 0) {
            System.out.print(0);
            return;
        }
        if (q1 != 0) {
            System.out.print(q1);
        }
        if (q1 != 0 && q2 != 0) {
            System.out.print(" ");
        }
        if (q2 != 0) {
            System.out.format("%d/%d", q2, b);
        }
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "5\n" +
            "2/5 4/15 1/30 -2/60 8/3",
            "2\n" +
            "4/3 2/3",
            "3\n" +
            "1/3 -1/6 1/8"
        };
    }

    public static void main(String[] args) {
        new L1_009().test();
    }
}
