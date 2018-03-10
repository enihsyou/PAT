import java.io.InputStream;
import java.util.*;

public class L1_034 implements InputOutputAlgorithm {

    private Scanner scanner;

    private int[] store = new int[1000 + 1];

    private int answerIndex;

    private int answerTimes;

    @Override
    public void input(final InputStream stream) {
        this.scanner = new Scanner(stream);
        final int inputSize = scanner.nextInt();
        for (int i = 0; i < inputSize; i++) {
            inputLine();
        }
    }

    private void inputLine() {
        final int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            store[scanner.nextInt()]++;
        }
    }

    @Override
    public void solve() {
        int maxIndex = 0, maxTimes = 0;
        /*找出最大项*/
        for (int i = 0; i < store.length; i++) {
            int value = store[i];
            if (value >= maxTimes) {
                maxIndex = i;
                maxTimes = value;
            }
        }
        /*设置答案*/
        if (maxIndex > 0) {
            answerIndex = maxIndex;
            answerTimes = maxTimes;
        }
    }

    @Override
    public void output() {
        System.out.format("%d %d", answerIndex, answerTimes);
        System.out.println();
    }

    @Override
    public void run() {

    }


    public static void main(String[] args) {
        L1_034 main = new L1_034();

        main.input(System.in);
        main.solve();
        main.output();
    }


    static class L1_034Test extends TestAlgorithm {

        private L1_034Test() {
            super(new L1_034());
        }

        @Override
        public String[] setTestCases() {
            return new String[]{
                "4\n"
                    + "3 889 233 2\n"
                    + "5 100 3 233 2 73\n"
                    + "4 3 73 889 2\n"
                    + "2 233 123"
            };
        }

        public static void main(String[] args) {
            new L1_034Test().test();
        }
    }

}
