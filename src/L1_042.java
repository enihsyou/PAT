import java.io.InputStream;
import java.util.Scanner;

public class L1_042 extends TestAlgorithm {

    private int index;

    private final int TARGET_NUMBER = 250;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        index = 1;
        while (scanner.nextInt() != TARGET_NUMBER)
            index++;
    }

    @Override
    public void solve() {

    }

    @Override
    public void output() {
        System.out.println(index);
    }

    @Override
    public void run() {
        input(System.in);
        // solve();
        output();
    }

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "888 666 123 -233 250 13 250 -222"
        };
    }

    public static void main(String[] args) {
        new L1_042().test();
    }
}
