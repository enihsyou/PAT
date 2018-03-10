import java.io.InputStream;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Main {

    private int[] pending;

    private String[] ids;

    private int[] testNumbers;

    private int[] jikenNumbers;

    private int[] solvedIndex;

    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        final int inputSize = scanner.nextInt();
        ids = new String[inputSize];
        testNumbers = new int[inputSize];
        solvedIndex = new int[inputSize];
        jikenNumbers = new int[inputSize];

        for (int i = 0; i < inputSize; i++) {
            final String id = scanner.next();
            final int testNumber = scanner.nextInt();
            final int jikenNumber = scanner.nextInt();

            ids[i] = id;
            testNumbers[i] = testNumber;
            jikenNumbers[i] = jikenNumber;
        }

        final int pendingSize = scanner.nextInt();
        pending = new int[pendingSize];
        for (int i = 0; i < pendingSize; i++) {
            pending[i] = scanner.nextInt();
        }

        solvedIndex = new int[pendingSize];
    }

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

    public void output() {
        for (final int index : solvedIndex) {
            System.out.format("%s %d", ids[index], jikenNumbers[index]);
            System.out.println();
        }
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
