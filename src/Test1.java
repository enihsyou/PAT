import java.io.InputStream;
import java.util.Scanner;

public class Test1 extends TestAlgorithm {

    private int size;

    private String content;

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "4\n" +
            "This is a test case",
            "3\n" +
            "This is a test case",
            "1\n" +
            "This is a test case"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        size = scanner.nextInt();
        scanner.skip("\\n");
        content = scanner.nextLine();
    }

    @Override
    public void solve() {
        final int length = content.length();
        final int column = length / size + (length % size + size - 1) / size;
        System.out.println("column = " + column);
        for (int r = 0; r < size; r++) { // row
            for (int c = column - 1; c >= 0; c--) { // column
                if (c * size + r < length)
                    System.out.print(content.charAt(c * size + r));
                else
                    System.out.print(' ');
            }
            if (r != size - 1)
                System.out.println();
        }
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
        new Test1().test();
        new Test1().run();
    }
}
