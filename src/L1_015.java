import java.io.InputStream;
import java.util.Scanner;

public class L1_015 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int input = scanner.nextInt();
        char fillChar = scanner.next().charAt(0);
        for (int i = 0; i < 0.5 * input; i++) {
            for (int i1 = 0; i1 < input; i1++) {
                System.out.print(fillChar);
            }
            System.out.println();
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
            "10 a"
        };
    }

    public static void main(String[] args) {
        new L1_015().test();
    }
}
