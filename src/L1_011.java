import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class L1_011 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        String input = scanner.nextLine();
        String exclude = scanner.nextLine();
        final char[] chars = exclude.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (Arrays.binarySearch(chars, c) < 0)
                System.out.print(c);
        }
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
            "I love GPLT!  It's a fun game!\n" +
            "aeiou"
        };
    }

    public static void main(String[] args) {
        new L1_011().test();
    }
}
