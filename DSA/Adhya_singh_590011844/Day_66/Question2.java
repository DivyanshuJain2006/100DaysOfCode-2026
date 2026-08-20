import java.io.*;
import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static List<Integer> inorder(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }

    static int[] mergeUnique(List<Integer> a, List<Integer> b) {

        int i = 0;
        int j = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i < a.size() || j < b.size()) {

            int value;

            if (j == b.size() ||
                (i < a.size() && a.get(i) < b.get(j))) {

                value = a.get(i++);

            } else if (i == a.size() ||
                       b.get(j) < a.get(i)) {

                value = b.get(j++);

            } else {
              
                value = a.get(i++);
                j++;
            }

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {

                result.add(value);
            }
        }

        int[] answer = new int[result.size()];

        for (i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n1 = Integer.parseInt(br.readLine().trim());

            int[] tree1 = new int[n1];
            int count = 0;

            while (count < n1) {

                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && count < n1) {
                    tree1[count++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            int n2 = Integer.parseInt(br.readLine().trim());

            int[] tree2 = new int[n2];
            count = 0;

            while (count < n2) {

                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && count < n2) {
                    tree2[count++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            TreeNode root1 = buildTree(tree1);
            TreeNode root2 = buildTree(tree2);

            List<Integer> list1 = inorder(root1);
            List<Integer> list2 = inorder(root2);

            int[] answer = mergeUnique(list1, list2);

            for (int i = 0; i < answer.length; i++) {
                if (i > 0) {
                    output.append(' ');
                }
                output.append(answer[i]);
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}