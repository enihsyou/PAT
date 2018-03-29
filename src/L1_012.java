import java.io.InputStream;
import java.util.Scanner;

public class L1_012 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int input = scanner.nextInt();
        String[] factorials = new String[]{
            "1",
            "2",
            "4",
            "8",
            "16",
            "32",
            "64",
            "128",
            "256",
            "512",
            "1024",
            "2048",
            "4096",
            "8192",
            "16384",
            "32768",
            "65536",
            "131072",
            "262144",
            "524288",
            "1048576",
            "2097152",
            "4194304"
        };
        System.out.format("2^%d = %s", input, factorials[input]);
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
            "5"
        };
    }

    public static void main(String[] args) {
        new L1_012().test();
    }
}
