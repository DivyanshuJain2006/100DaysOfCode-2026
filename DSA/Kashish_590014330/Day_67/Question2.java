import java.util.Scanner;

public class Question2 {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }


    static class BalanceCounts {
        int countNeg1 = 0;
        int count0 = 0;
        int countPos1 = 0;
    }


    public static Node buildBST(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node root = new Node(arr[mid]);

        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);

        return root;
    }

    public static int calculateHeightAndCounts(Node node, BalanceCounts counts) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeightAndCounts(node.left, counts);
        int rightHeight = calculateHeightAndCounts(node.right, counts);

        int balanceFactor = rightHeight - leftHeight;

        if (balanceFactor == -1) {
            counts.countNeg1++;
        } else if (balanceFactor == 0) {
            counts.count0++;
        } else if (balanceFactor == 1) {
            counts.countPos1++;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildBST(arr, 0, n - 1);

        BalanceCounts counts = new BalanceCounts();
        calculateHeightAndCounts(root, counts);

        System.out.println(counts.countNeg1 + " " + counts.count0 + " " + counts.countPos1);

        sc.close();
    }
}