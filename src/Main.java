import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
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

    public void run() {
        input(System.in);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
