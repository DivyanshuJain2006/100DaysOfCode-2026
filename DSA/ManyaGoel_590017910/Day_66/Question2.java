import java.util.*;

public class Question2 {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode buildTree(Scanner sc, int tree) {
        System.out.print("Enter number of elements in Tree " + tree + ": ");
        int n = sc.nextInt();
        if (n == 0) return null;
        System.out.println("Enter " + n + " elements in compact level-order (-1 for null):");
        int rootVal = sc.nextInt();
        if (rootVal == -1) {
            for (int i = 1; i < n; i++)
                sc.nextInt();
            return null;
        }
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int count = 1;
        while (!q.isEmpty() && count < n) {
            TreeNode cur = q.poll();

            if (count < n) {
                int val = sc.nextInt();
                count++;

                if (val != -1) {
                    cur.left = new TreeNode(val);
                    q.offer(cur.left);
                }
            }

            if (count < n) {
                int val = sc.nextInt();
                count++;

                if (val != -1) {
                    cur.right = new TreeNode(val);
                    q.offer(cur.right);
                }
            }
        }

        return root;
    }

    public static void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static String mergeBSTs(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();

        pushLeft(root1, s1);
        pushLeft(root2, s2);

        StringBuilder result = new StringBuilder("[");
        Integer last = null;
        boolean first = true;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            TreeNode node;

            if (s2.isEmpty() ||
                (!s1.isEmpty() && s1.peek().val <= s2.peek().val)) {

                node = s1.pop();
                pushLeft(node.right, s1);

            } else {
                node = s2.pop();
                pushLeft(node.right, s2);
            }

            if (last == null || node.val != last) {
                if (!first)
                    result.append(", ");

                result.append(node.val);
                last = node.val;
                first = false;
            }
        }

        return result.append("]").toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("\n--- Enter Tree 1 ---");
            TreeNode root1 = buildTree(sc, 1);

            System.out.println("\n--- Enter Tree 2 ---");
            TreeNode root2 = buildTree(sc, 2);

            System.out.println("Sorted unique employee IDs: " + mergeBSTs(root1, root2));
        }
        sc.close();
    }
}