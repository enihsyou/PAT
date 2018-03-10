import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/** 实现这个类以构造测试用例 */
public abstract class TestAlgorithm {

    /** 需要测试的算法 */
    private InputOutputAlgorithm main;

    public TestAlgorithm(final InputOutputAlgorithm main) {
        this.main = main;
    }

    public void test() {
        final String[] testCases = setTestCases();
        for (final String s : testCases) {
            main.input(new ByteArrayInputStream(s.getBytes(Charset.forName("UTF-8"))));
            main.solve();
            main.output();
        }
    }

    /** 返回一个字符数组，每一项都是一次单独的对StdIn的Input测试 */
    public abstract String[] setTestCases();
}
