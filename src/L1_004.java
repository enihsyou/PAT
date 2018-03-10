import java.io.InputStream;
import java.util.Scanner;

public class L1_004 implements InputOutputAlgorithm {

    private int inputF;

    private int answerC;

    @Override
    public void input(final InputStream stream) {
        this.inputF = new Scanner(stream).nextInt();
    }

    @Override
    public void solve() {
        this.answerC = 5 * (inputF - 32) / 9;
    }

    @Override
    public void output() {
        System.out.format("Celsius = %s", answerC);
        System.out.println();
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }


    static class L1_004Test extends TestAlgorithm {

        public L1_004Test() {
            super(new L1_004());
        }

        @Override
        public String[] setTestCases() {
            return new String[]{"150"};
        }

        public static void main(String[] args) {
            new L1_004Test().test();
        }
    }

    public static void main(String[] args) {
        new L1_004().run();
    }
}

