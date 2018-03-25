import java.io.InputStream;
import java.util.Scanner;

public class Test4 extends TestAlgorithm {

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "169"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        final int input = scanner.nextInt();
        System.out.println(1.8*(input - 100));
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

    public static void main(String[] args) {
        new Test4().test();
        new Test4().run();
    }
}
