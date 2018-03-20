import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class L1_035 extends TestAlgorithm {

    private ArrayList<String> names;

    private String second;

    private String fourteenth;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        names = new ArrayList<String>();
        do {
            final String next = scanner.next();
            if (".".equals(next)) break;
            names.add(next);
        } while (true);
    }

    @Override
    public void solve() {
        second = null;
        fourteenth = null;
        if (names.size() >= 14) {
            fourteenth = names.get(13);
        }
        if (names.size() >= 2) {
            second = names.get(1);
        }
    }

    @Override
    public void output() {
        if (fourteenth != null) {
            System.out.printf("%s and %s are inviting you to dinner...", second, fourteenth);
        } else if (second != null) {
            System.out.format("%s is the only one for you...", second);
        } else {
            System.out.println("Momo... No one is for you ...");
        }
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
            "GaoXZh\n" +
            "Magi\n" +
            "Einst\n" +
            "Quark\n" +
            "LaoLao\n" +
            "FatMouse\n" +
            "ZhaShen\n" +
            "fantacy\n" +
            "latesum\n" +
            "SenSen\n" +
            "QuanQuan\n" +
            "whatever\n" +
            "whenever\n" +
            "Potaty\n" +
            "hahaha\n" +
            ".",
            "LaoLao\n" +
            "FatMouse\n" +
            "whoever\n" +
            ".",
            "LaoLao\n" +
            "."
        };
    }

    public static void main(String[] args) {
        new L1_035().test();
    }
}
