import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Test7 extends TestAlgorithm {

    private HashMap<String, Node> nodes;

    private LinkedList<Node> mainList;

    private ArrayList<Integer> mainListValue;

    private LinkedList<Node> deletedList;

    private String startAddress;

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "00100 5\n" +
            "99999 -7 87654\n" +
            "23854 -15 00000\n" +
            "87654 15 -1\n" +
            "00000 -15 99999\n" +
            "00100 21 23854"
        };
    }

    private static class Node {

        Node(final String address, final int value, final String next) {
            this.address = address;
            this.value = value;
            this.next = next;
        }

        String address;

        int value;

        String next;

        @Override
        public String toString() {
            return address + " " + value + " " + next;
        }
    }

    @Override
    public void input(final InputStream stream) {
        final Scanner scanner = new Scanner(stream);
        startAddress = scanner.next("\\d+");
        final int size = scanner.nextInt();
        // nodes = new HashMap<>(size);
        // mainList = new LinkedList<>();
        // mainListValue = new ArrayList<>();
        // deletedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            final String address = scanner.next();
            final int value = scanner.nextInt();
            final String next = scanner.next();

            nodes.put(address, new Node(address, value, next));
        }
    }


    @Override
    public void solve() {
        String currentAddress = startAddress;
        while (!"-1".equals(currentAddress)) {

            final Node node = nodes.get(currentAddress);
            if (mainListValue.contains(Math.abs(node.value))) {
                addToDelete(node);
            } else {
                addToMain(node);
                mainListValue.add(Math.abs(node.value));
            }
            currentAddress = node.next;
        }
    }

    private void addToMain(final Node node) {
        if (mainList.isEmpty()) {
            mainList.add(new Node(node.address, node.value, "-1"));
        } else {
            final Node last = mainList.getLast();
            last.next = node.address;
            mainList.add(new Node(node.address, node.value, "-1"));
        }

    }

    private void addToDelete(final Node node) {
        if (deletedList.isEmpty()) {
            deletedList.add(new Node(node.address, node.value, "-1"));
        } else {
            final Node last = deletedList.getLast();
            last.next = node.address;
            deletedList.add(new Node(node.address, node.value, "-1"));
        }
    }


    @Override
    public void output() {
        // mainList.forEach(System.out::println);
        // deletedList.forEach(System.out::println);
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    public static void main(String[] args) {
        new Test7().test();
        // new Test6().run();
    }
}
