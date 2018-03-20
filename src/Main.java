import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private int index;

    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);

        index = 1;
        while (scanner.nextInt() != 250)
            index++;
    }

    public void output() {
        System.out.println(index);
    }

    public void run() {
        input(System.in);
        // solve();
        output();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
