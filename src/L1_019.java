import java.io.InputStream;
import java.util.Scanner;

public class L1_019 extends TestAlgorithm {

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int full_a = scanner.nextInt();
        int full_b = scanner.nextInt();
        int remain_a = full_a;
        int remain_b = full_b;
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            int call_a = scanner.nextInt();
            int push_a = scanner.nextInt();
            int call_b = scanner.nextInt();
            int push_b = scanner.nextInt();

            int all = call_a + call_b;
            if (push_a == all && push_b == all)
                continue;

            if (push_a != all && push_b != all)
                continue;

            if (push_a == all) // A Fail this role
                remain_a -= 1; // A drink
            else
                remain_b -= 1;

            if (remain_a == 0) {
                System.out.println("A");
                System.out.println(full_b - remain_b);
                return;
            } else if (remain_b == 0) {
                System.out.println("B");
                System.out.println(full_a - remain_a);
                return;
            }
        }
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
            "1 1\n" +
            "6\n" +
            "8 10 9 12\n" +
            "5 10 5 10\n" +
            "3 8 5 12\n" +
            "12 18 1 13\n" +
            "4 16 12 15\n" +
            "15 1 1 16"
        };
    }

    public static void main(String[] args) {
        new L1_019().test();
    }
}
