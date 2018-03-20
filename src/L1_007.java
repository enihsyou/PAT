import java.io.InputStream;
import java.util.Scanner;

public class L1_007 extends TestAlgorithm {

    private String pending;

    private String[] transform = new String[]{
        "ling",
        "yi",
        "er",
        "san",
        "si",
        "wu",
        "liu",
        "qi",
        "ba",
        "jiu"
    };

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        pending = scanner.next().trim();
    }

    @Override
    public void solve() {
        final char[] charArray = pending.toCharArray();
        for (int i1 = 0, charArrayLength = charArray.length; i1 < charArrayLength; i1++) {
            if (i1 != 0)
                System.out.print(' ');
            final char c = charArray[i1];
            if (c == '-')
                System.out.print("fu");
            final int i = c - '0';
            if (0 <= i && i <= 9) {
                System.out.print(transform[i]);
            }
        }

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
            "-600",
            "10",
            "0",
            "1",
            "-1"
        };
    }
}
