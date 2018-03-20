import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/** 实现这个类以构造测试用例 */
public abstract class TestAlgorithm implements InputOutputAlgorithm{

    private static final int DELIMITER_LENGTH = 80;

    /** 需要测试的算法 */
    private InputOutputAlgorithm main;

    public TestAlgorithm() {
        this.main = this;
    }

    public void test() {
        final String[] testCases = setTestCases();
        for (final String s : testCases) {
            System.out.println("Test for:");
            System.out.println(s);

            System.out.println();
            System.out.println("Results are:");
            final long startTime = System.nanoTime();
            main.input(new ByteArrayInputStream(s.getBytes(Charset.forName("UTF-8"))));
            main.solve();
            main.output();
            final long estimatedTime = System.nanoTime() - startTime;
            System.out.format("One time estimated time: %sms%n",
                TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
            System.out.println(new String(new char[DELIMITER_LENGTH]).replace("\0", "-"));
        }
    }

    /** 返回一个字符数组，每一项都是一次单独的对StdIn的Input测试 */
    protected abstract String[] setTestCases();
}
