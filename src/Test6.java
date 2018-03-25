import java.io.InputStream;
import java.util.Scanner;

public class Test6 extends TestAlgorithm {

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "3\n" +
            "1 08:30\n" +
            "2 09:21\n" +
            "0 21:07"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        final int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            if (i != 0)
                System.out.println();
            final int day = scanner.nextInt();
            final String[] next = scanner.next("\\d{2}:\\d{2}").split(":");
            final int hour = Integer.parseInt(next[0]);
            final int minute = Integer.parseInt(next[1]);
            judge(day, hour, minute);
        }
    }

    private void judge(final int day, final int hour, final int minute) {
        System.out.println("day = [" + day + "], hour = [" + hour + "], minute = [" + minute + "]");
        if (day == 0)
            output(day, hour, minute);
        else {
            final int minutes = ((day - 1) * 24 + hour) * 60 + minute;
            System.out.println("minutes = " + minutes);
            final int day2 = minutes / 60 / 48 + 1;
            final int hour2 = minutes / 60 % 48 / 2;
            final int minute2 = minutes / 2 % 60;
            output(day2, hour2, minute2);
        }
    }

    private void output(final int day, final int hour, final int minute) {
        System.out.format("%d %02d:%02d", day, hour, minute);
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
        solve();
        output();
    }

    public static void main(String[] args) {
        new Test6().test();
        // new Test6().run();
    }
}
