import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class L1_010 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        final int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {

            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        for (int i = 0; i < 3; i++) {
            if (i != 0) System.out.print("->");
            System.out.print(ints[i]);
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
        solve();
        output();
    }

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "4 2 8"
        };
    }

    public static void main(String[] args) {
        new L1_010().test();
    }
}
