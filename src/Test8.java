import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Test8 extends TestAlgorithm {

    private double[] powers;

    private double power;

    private double rate;


    @Override
    protected String[] setTestCases() {
        return new String[]{
            "10 18.0 1.00\n" +
            "3 2 3 5\n" +
            "1 9\n" +
            "1 4\n" +
            "1 7\n" +
            "0 7\n" +
            "2 6 1\n" +
            "1 8\n" +
            "0 9\n" +
            "0 4\n" +
            "0 3"
        };
    }


    @Override
    public void input(final InputStream stream) { // fixme need tree structure
        final Scanner scanner = new Scanner(stream);
        powers = new double[scanner.nextInt()];
        power = scanner.nextDouble();
        rate = (100 - scanner.nextDouble()) / 100;
        powers[0] = power;

        for (int i = 0; i < powers.length; i++) {
            final int desi = scanner.nextInt();
            if (desi == 0)
                powers[i] = powers[i] * scanner.nextInt();
            else
                for (int i1 = 0; i1 < desi; i1++) {
                    final int the = scanner.nextInt();
                    powers[the] = powers[i] * rate;
                }
        }
    }


    @Override
    public void solve() {

    }

    @Override
    public void output() {
        System.out.println((int) DoubleStream.of(powers).sum());
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    public static void main(String[] args) {
        new Test8().test();
        // new Test6().run();
    }
}
