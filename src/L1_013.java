import java.io.InputStream;
import java.util.Scanner;

public class L1_013 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int input = scanner.nextInt();
        String[] factorials = new String[]{
            "1",
            "1",
            "3",
            "9",
            "37",
            "169",
            "981",
            "6429",
            "49669",
            "430861",
            "4208925",
            "45345165",
            "536229373",
            "6884917597",
            "95473049469",
            "1420609412637",
            "22580588347741",
            "381713065286173"
        };
        System.out.println(factorials[input]);
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
            "3"
        };
    }

    public static void main(String[] args) {
        new L1_013().test();
    }
}
