import java.util.Scanner;

abstract class TestAlgorithm implements InputOutputAlgorithm {

    protected void test() {
        final String[] testInput = setTest();
        for (final String s : testInput) {
            final Scanner scanner = new Scanner(s);
            input(scanner);
            solve();
            output();
        }
    }

    protected abstract String[] setTest();
}
