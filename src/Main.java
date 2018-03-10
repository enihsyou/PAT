import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Main {
    private int input;

    private ArrayList<Integer> store;

    private int answerStartIndex;

    private int answerMaxLength;

    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        this.input = scanner.nextInt();
        assert input > 1;
        this.store = new ArrayList<Integer>((int) Math.log(input));
    }

    public void solve() {
        getFactors();
        int startIndex = 0;
        int maxLength = 1;
        int currentStart = 0;
        int currentIndex = 1;
        while (currentIndex < store.size()) {
            final int indexDiffer = currentIndex - currentStart;
            final int currentLength = indexDiffer + 1;
            final int currentFactor = store.get(currentIndex);
            final int exceptNextSequenceFactor =
                store.get(currentStart) + indexDiffer;

            if (currentFactor == exceptNextSequenceFactor) {
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

    public void output() {
        System.out.println(answerMaxLength);
        for (int i = 0; i < answerMaxLength; i++) {
            if (i != 0) System.out.print('*');
            System.out.print(store.get(answerStartIndex + i));
        }
        System.out.println();
    }

    public void run() {
        input(System.in);
        solve();
        output();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
