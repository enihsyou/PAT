import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class L1_006 implements InputOutputAlgorithm {

    private int input;

    private ArrayList<Integer> store;

    private int answerStartIndex;

    private int answerMaxLength;

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        this.input = scanner.nextInt();
        assert input > 1;
        this.store = new ArrayList<Integer>((int) Math.log(input));
    }

    @Override
    public void solve() {
        getFactors();
        int startIndex = 0; // 最长序列的起始序号
        int maxLength = 1; // 最长序列的长度
        int currentStart = 0; // 当前处理序列的起始序号
        int currentIndex = 1; // 当前处理的序号，和上面相减就是长度
        while (currentIndex < store.size()) {
            final int indexDiffer = currentIndex - currentStart;
            final int currentLength = indexDiffer + 1;
            final int currentFactor = store.get(currentIndex); // 循环中得到的下一个因子数值
            final int exceptNextSequenceFactor = // 如果需要增长序列 期望的下一个因子数值
                store.get(currentStart) + indexDiffer;

            if (currentFactor == exceptNextSequenceFactor) { // 如果当前因子是期望的
                if (currentLength > maxLength && multiplyCorrect(currentStart, currentLength)) {
                    startIndex = currentStart;
                    maxLength = currentLength;
                }
            } else {
                currentStart = currentIndex;
            }
            currentIndex++;
        }
        answerStartIndex = startIndex;
        answerMaxLength = maxLength;
    }

    private boolean multiplyCorrect(final int currentStart, final int currentLength) {
        int mul = 1;
        for (int i = 0; i < currentLength; i++) {
            mul *= store.get(currentStart + i);
        }
        return mul % input != 0;
    }

    private void getFactors() {
        int factor = 2; // 因子
        while (factor <= input) {
            if (input % factor == 0) {
                store.add(factor);
            }
            factor++;
        }
    }

    @Override
    public void output() {
        System.out.println(answerMaxLength);
        for (int i = 0; i < answerMaxLength; i++) {
            if (i != 0) System.out.print('*');
            System.out.print(store.get(answerStartIndex + i));
        }
        System.out.println();
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    static class L1_006Test extends TestAlgorithm {

        public L1_006Test(final InputOutputAlgorithm main) {
            super(main);
        }

        @Override
        protected String[] setTestCases() {
            return new String[]{
                "630",
                "16",
                Integer.toString(3*5*6*7*8),
                Integer.toString(6*7*8*2)
            };
        }

        public static void main(String[] args) {
            new L1_006Test(new L1_006()).test();
        }
    }
}

