import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        char fillChar = scanner.next().charAt(0);
        for (int i = 0; i < 0.5 * input; i++) {
            for (int i1 = 0; i1 < input; i1++) {
                System.out.print(fillChar);
            }
            System.out.println();
        }
    }
}
