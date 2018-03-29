import java.io.InputStream;
import java.util.Scanner;

public class Test3 extends TestAlgorithm {

    private int[] table;

    private int[] adder1;

    private int[] adder2;

    private StringBuilder result;

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "30527\n" +
            "06203\n" +
            "415",
            "0527\n" +
            "6203\n" +
            "415"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        // table = new StringBuilder(scanner.nextLine()).reverse().chars().map(operand -> operand - '0').toArray();
        // adder1 = new StringBuilder(scanner.nextLine()).reverse().chars().map(operand -> operand - '0').toArray();
        // adder2 = new StringBuilder(scanner.nextLine()).reverse().chars().map(operand -> operand - '0').toArray();
        result = new StringBuilder();
    }

    @Override
    public void solve() {
        final int add_times = Math.max(adder1.length, adder2.length);
        int counter = 0;
        for (int i = 0; i < add_times; i++) {
            final int ary = getAry(i);

            final int a1 = getAdder(adder1, i);
            final int a2 = getAdder(adder2, i);
            final int try_add = a1 + a2 + counter;
            counter = try_add / ary;
            final int added = try_add % ary;
            result.append(Integer.toString(added));
        }
        if (counter != 0)
            result.append(Integer.toString(counter));
    }

    private int getAry(final int i) {
        if (table.length > i && table[i] != 0) {
            return table[i];
        } else return 10;
    }

    private int getAdder(final int[] adder, final int i) {
        if (adder.length > i) {
            return adder[i];
        } else return 0;
    }


    @Override
    public void output() {
        System.out.print(result.reverse().toString().replaceFirst("0*", ""));
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    public static void main(String[] args) {
        new Test3().test();
        new Test3().run();
    }
}
