import java.io.InputStream;
import java.util.Scanner;

public class L1_042 extends TestAlgorithm {

    private String input;

    private char[] chars;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        input = scanner.next();
    }

    @Override
    public void solve() {
        chars = input.toCharArray();
    }

    @Override
    public void output() {
        System.out.print(chars[6]);
        System.out.print(chars[7]);
        System.out.print(chars[8]);
        System.out.print(chars[9]); // year
        System.out.print(chars[5]); // -
        System.out.print(chars[0]);
        System.out.print(chars[1]); // month
        System.out.print(chars[2]); // -
        System.out.print(chars[3]);
        System.out.print(chars[4]); // dat
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
            "03-15-2017"
        };
    }

    public static void main(String[] args) {
        new L1_042().test();
    }
}
