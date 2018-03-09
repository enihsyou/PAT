import java.util.*;

public class L1_034 {

    Scanner scanner = new Scanner(System.in);

    private int[] store = new int[1000 + 1];

    private int answerIndex;

    private int answerTimes;

    void input() {
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

    void solve() {
        int maxIndex = 0, maxTimes = 0;
        /*找出最大项*/
        for (int i = 0; i < store.length; i++) {
            int value = store[i];
            if (value >= maxTimes){
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

    void output() {
        System.out.format("%d %d", answerIndex, answerTimes);
        System.out.println();
    }


    public static void main(String[] args) {
        L1_034 main = new L1_034();

        main.input();
        main.solve();
        main.output();
    }
}

class L1_034Test extends TestAlgorithm {

    private L1_034 main = new L1_034();

    @Override
    protected String[] setTest() {
        return new String[]{
            "4\n"
                + "3 889 233 2\n"
                + "5 100 3 233 2 73\n"
                + "4 3 73 889 2\n"
                + "2 233 123"
        };
    }

    @Override
    public void input(final Scanner scanner) {
        main.scanner = scanner;
        main.input();
    }

    @Override
    public void solve() {
        main.solve();
    }

    @Override
    public void output() {
        main.output();
    }

    public static void main(String[] args) {
        new L1_034Test().test();
    }
}
