import java.io.InputStream;
import java.util.Scanner;

public class L1_008 extends TestAlgorithm {

    private int b;

    private int a;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    @Override
    public void solve() {
        for (int i = a; i <= b; i++) {
            System.out.format("%5d", i);
            if ((i - a + 1) % 5 == 0 || i == b) {
                System.out.println();
            }
        }
        System.out.format("Sum = %d", (a + b) * (b - a + 1) / 2);
    }

    @Override
    public void output() {

    }

    @Override
    public void run() {
        input(System.in);
        solve();
        // output();
    }

    @Override
    public String[] setTestCases() {
        return new String[]{
            "-3 8",
            "-3 6"
        };
    }

    public static void main(String[] args) {
        new L1_008().test();
    }
}
