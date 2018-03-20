import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class L1_005 extends TestAlgorithm {

    private int[] pending; // 需要求解的试机座位号

    static class Data implements Comparable<Data>{

        String id;

        int testNumber;

        int jukenNumber;

        Data(final String id, final int testNumber, final int jukenNumber) {
            this.id = id;
            this.testNumber = testNumber;
            this.jukenNumber = jukenNumber;
        }

        @Override
        public int compareTo(final Data o2) {
            if (this.testNumber == o2.testNumber)
                return 0;
            if (this.testNumber < o2.testNumber)
                return -1;
            else
                return 1;
        }

        static class Comp implements Comparator<Data> {

            @Override
            public int compare(final Data o1, final Data o2) {
                return o1.compareTo(o2);
            }
        }
    }

    private Data[] datum;

    private int[] solved; // 求出的考试座位号

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        final int inputSize = scanner.nextInt(); // 输入的信息数量
        datum = new Data[inputSize];

        for (int i = 0; i < inputSize; i++) {
            final String id = scanner.next(); // 学生学号
            final int testNumber = scanner.nextInt(); // 试机座位
            final int jukenNumber = scanner.nextInt(); // 考试座位

            datum[i] = new Data(id, testNumber, jukenNumber);
        }

        final int pendingSize = scanner.nextInt(); // 需要求解的问题数量
        pending = new int[pendingSize];
        for (int i = 0; i < pendingSize; i++) {
            pending[i] = scanner.nextInt();
        }

        solved = new int[pendingSize];
    }

    @Override
    public void solve() {
        Arrays.sort(datum, new Data.Comp());

        for (int i = 0; i < this.pending.length; i++) {
            final int pendFor = pending[i];
            /*Search testNumbers for testNumber*/
            final int search = Arrays.binarySearch(datum, new Data("", pendFor, 0));
            if (search >= 0) solved[i] = search;
            else throw new RuntimeException();
        }
    }

    @Override
    public void output() {
        for (final int index : solved) {
            System.out.format("%s %d", datum[index].id, datum[index].jukenNumber);
            System.out.println();
        }
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
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
}
