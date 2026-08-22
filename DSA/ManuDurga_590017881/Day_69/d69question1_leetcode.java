package Day_69;

import java.util.*;

public class d69question1_leetcode {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] arr, int lo, int hi) {
        if (idx >= arr.length) return null;
        int v = arr[idx];
        if (v < lo || v > hi) return null;

        TreeNode node = new TreeNode(v);
        idx++;
        node.left = build(arr, lo, v);
        node.right = build(arr, v, hi);
        return node;
    }
}
