import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class L1_018 extends TestAlgorithm {

    private static final Pattern COMPILE = Pattern.compile(":");

    private int hour;

    private int minute;

    private String output;

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "19:05",
            "07:05",
            "12:00",
            "12:01"
        };
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        final String l = scanner.nextLine();
        final String[] split = COMPILE.split(l);
        hour = Integer.parseInt(split[0]);
        minute = Integer.parseInt(split[1]);
    }

    @Override
    public void solve() {
        if (hour > 12) {
            if (minute > 0)
                output = repeat(hour + 1 - 12);
            else
                output = repeat(hour - 12);
        } else if (hour == 12) {
            if (minute == 0)
                output = String.format("Only %02d:%02d.  Too early to Dang.", hour, minute);
            else
                output = repeat(hour + 1 - 12);
        } else
            output = String.format("Only %02d:%02d.  Too early to Dang.", hour, minute);
    }

    private String repeat(int time) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < time; i++) {
            builder.append("Dang");
        }
        return builder.toString();
    }

    @Override
    public void output() {
        System.out.println(output);
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    public static void main(String[] args) {
        new L1_018().test();
    }
}
