import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L1_003 {

    private Scanner scanner = new Scanner(System.in);

    String input;

    private Map<String, Integer> store = new TreeMap<String, Integer>();

    void input() {
        input = scanner.next();
    }

    void solve() {
        for (int i = 0; i < input.length(); i++) {
            String c = input.substring(i, i + 1);

            //for(String c : input.split("")){
            if (store.containsKey(c)) {
                int incremented = store.get(c) + 1;
                store.put(c, incremented);
            } else
                store.put(c, 1);
        }
    }

    void output() {
        for (Map.Entry<String, Integer> entry : store.entrySet()) {
            System.out.format("%s:%s\n", entry.getKey(), entry.getValue());
        }
    }

    static void test(String input) {
        L1_003 L1_003 = new L1_003();
        //    L1_003.input();
        L1_003.input = input;
        L1_003.solve();
        L1_003.output();
        System.out.println();
    }

    static void test() {
        test("100311");
        test("100312");
    }

    public static void L1_003(String[] args) {
        L1_003 L1_003 = new L1_003();
        L1_003.input();
        L1_003.solve();
        L1_003.output();
    }
}
