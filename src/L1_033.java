import java.util.Scanner;

public class L1_033 {

    private Scanner scanner = new Scanner(System.in);

    int inputYear;

    int inputDigit;

    int answerAge;

    int answerYear;

    void input() {
        inputYear = scanner.nextInt();
        inputDigit = scanner.nextInt();
    }

    void solve() {
        int currentYear = inputYear;
        while (currentYear < 9877) {
            if (distentDigit(currentYear) == inputDigit) {
                answerAge = calculateAge(inputYear, currentYear);
                answerYear = currentYear;
                return;
            }
            currentYear++;
        }
    }

    private int calculateAge(int inputYear2, int currentYear) {
        return currentYear - inputYear2;
    }

    private int distentDigit(int currentYear) {
        String numberString = String.format("%04d", currentYear);
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < numberString.length(); i++) {
            int c = numberString.charAt(i);
            count[c - '0']++;
        }
        int c = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                c++;
        }
        return c;
    }

    void output() {
        System.out.format("%d %s\n", answerAge, String.format("%04d", answerYear));
    }

    static void test(int a, int b) {
        L1_033 L1_033 = new L1_033();
        L1_033.inputYear = a;
        L1_033.inputDigit = b;
        L1_033.solve();
        L1_033.output();
        System.out.println();
    }

    static void test() {
        test(1988, 4);
        test(1, 2);
    }

    public static void L1_004(String[] args) {
        //test();
        L1_033 L1_033 = new L1_033();
        L1_033.input();
        L1_033.solve();
        L1_033.output();
    }
}
