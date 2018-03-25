import java.io.InputStream;
import java.util.Scanner;

public class Test5 extends TestAlgorithm {

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "3\n" +
            "169 136\n" +
            "150 81\n" +
            "178 155"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        final int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            if (i != 0)
                System.out.println();
            final int height = scanner.nextInt();
            final int weight = scanner.nextInt();
            judge(height, weight);
        }
    }

    private void judge(final int height, final int weight) {
        final double standard = 1.8 * (height - 100);
        final double upper = standard * 1.1;
        final double lower = standard * 0.9;
        if (lower < weight && weight < upper)
            System.out.print("You are wan mei!");
        else if (lower >= weight)
            System.out.print("You are tai shou le!");
        else if (upper <= weight)
            System.out.print("You are tai pang le!");
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
        new Test5().test();
        new Test5().run();
    }
}
