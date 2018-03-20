import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class L3_010 extends TestAlgorithm {

    private int inputSize;

    private BinaryTree tree;

    static class TreeNode implements Comparable<TreeNode> {

        int value;

        TreeNode left;

        TreeNode right;

        public TreeNode(final int value) {
            this.value = value;
        }

        private void addRight(int value) {
            right = new TreeNode(value);
        }

        private void addLeft(int value) {
            left = new TreeNode(value);
        }

        @Override
        public int compareTo(final TreeNode o) {
            if (value >= o.value) {
                if (value == o.value)
                    return 0;
                return 1;
            }
            return -1;
        }
    }

    class BinaryTree {

        TreeNode root;

        boolean isComplete = true;

        void add(int value) {
            if (root == null) {
                root = new TreeNode(value);
                return;
            }
            TreeNode current = root;
            while (true) {
                if (current.value > value) {
                    if (current.right == null) {
                        current.addRight(value);
                        break;
                    } else
                        current = current.right;
                } else if (current.value < value) {
                    if (current.left == null) {
                        current.addLeft(value);
                        break;
                    } else
                        current = current.left;
                } else {
                    throw new RuntimeException();
                }
            }
        }

        void print() {
            List<Integer> list = new ArrayList<Integer>(inputSize);
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (node.left == null ^ node.right == null) {
                    isComplete = false;
                }
                list.add(node.value);
            }
            for (int i = 0; i < list.size(); i++) {
                if (i != 0) System.out.print(' ');
                int a = list.get(i);
                System.out.print(a);
            }
            System.out.println();
        }

    }

    @Override
    public void input(final InputStream stream) {
        Scanner scanner = new Scanner(stream);
        tree = new BinaryTree();
        inputSize = scanner.nextInt();
        for (int i = 0; i < inputSize; i++) {
            tree.add(scanner.nextInt());
        }
    }

    @Override
    public void solve() {

    }

    @Override
    public void output() {
        tree.print();
        if (tree.isComplete) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    @Override
    public void run() {
        input(System.in);
        solve();
        output();
    }

    @Override
    protected String[] setTestCases() {
        return new String[]{
            "9\n" +
            "38 45 42 24 58 30 67 12 51",
            "8\n" +
            "38 24 12 45 58 67 42 51"
        };
    }

    public static void main(String[] args) {
        new L3_010().test();
    }
}
