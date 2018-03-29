import java.io.InputStream;
import java.util.Scanner;

public class L1_017 extends TestAlgorithm {


    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        String input = scanner.nextLine();
        int digits = 0;
        int twos = 0;
        double minus = 1;
        double even = 1;
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == '-') {
                minus = 1.5;
                continue;
            }
            final int digit = Character.digit(c, 10);
            if (digit == 2) {
                twos += 1;
            }
            if (i == input.length() - 1 && digit % 2 == 0) {
                even = 2.0;
            }
            digits += 1;
        }
        System.out.format("%.2f%%", minus * even * twos / digits * 100);
    }

    @Override
    public void solve() {
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
            "-13142223336"
        };
    }

    public static void main(String[] args) {
        new L1_017().test();
    }
}
