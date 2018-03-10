import java.util.Scanner;

public class Main {

    private int inputF;

    private int answerC;

    private void input(final Scanner scanner) {
        this.inputF = scanner.nextInt();
    }

    private void solve() {
        this.answerC = 5 * (inputF - 32) / 9;
    }

    private void output() {
        System.out.format("Celsius = %s", answerC);
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.input(new Scanner(System.in));
        main.solve();
        main.output();
    }
}
