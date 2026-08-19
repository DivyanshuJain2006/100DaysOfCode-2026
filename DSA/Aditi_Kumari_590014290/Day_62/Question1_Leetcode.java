package Day_62;

public class Question1_Leetcode {
    int val;
    Question1_Leetcode left;
    Question1_Leetcode right;

    Question1_Leetcode() {}

    Question1_Leetcode(int val) {
        this.val = val;
    }

    Question1_Leetcode(int val, Question1_Leetcode left, Question1_Leetcode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean evaluateTree(Question1_Leetcode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        }
        return left && right;
    }
}