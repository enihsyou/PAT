import java.io.*;
import java.util.*;

public class L1_005 implements InputOutputAlgorithm {

    private int[] pending;

    private String[] ids;

    private int[] testNumbers;

    private int[] jikenNumbers;

    private int[] solvedIndex;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        final int inputSize = scanner.nextInt(); // 输入的信息数量
        ids = new String[inputSize];
        testNumbers = new int[inputSize];
        solvedIndex = new int[inputSize];
        jikenNumbers = new int[inputSize];

        for (int i = 0; i < inputSize; i++) {
            final String id = scanner.next(); // 学生学号
            final int testNumber = scanner.nextInt(); // 试机座位
            final int jikenNumber = scanner.nextInt(); // 考试座位

            ids[i] = id;
            testNumbers[i] = testNumber;
            jikenNumbers[i] = jikenNumber;
        }

        final int pendingSize = scanner.nextInt(); // 需要求解的问题数量
        pending = new int[pendingSize];
        for (int i = 0; i < pendingSize; i++) {
            pending[i] = scanner.nextInt();
        }

        solvedIndex = new int[pendingSize];
    }

    @Override
    public void solve() {
        for (int i = 0; i < this.pending.length; i++) {
            final int pendFor = pending[i];
            /*Search testNumbers for testNumber*/
            for (int j = 0; j < testNumbers.length; j++) {
                final int number = testNumbers[j];
                if (number == pendFor)
                    solvedIndex[i] = j;
            }
        }
    }

    @Override
    public void output() {
        for (final int index : solvedIndex) {
            System.out.format("%s %d", ids[index], jikenNumbers[index]);
            System.out.println();
        }
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    static class L1_005Test extends TestAlgorithm {

        public L1_005Test(final InputOutputAlgorithm main) {
            super(main);
        }

        @Override
        public String[] setTestCases() {
            return new String[]{
                "4\n" +
                "10120150912233 2 4\n" +
                "10120150912119 4 1\n" +
                "10120150912126 1 3\n" +
                "10120150912002 3 2\n" +
                "2\n" +
                "3 4"
            };
        }

        public static void main(String[] args) {
            new L1_005Test(new L1_005()).test();
        }
    }

    public static void main(String[] args) {
        new L1_005().run();
    }
}
