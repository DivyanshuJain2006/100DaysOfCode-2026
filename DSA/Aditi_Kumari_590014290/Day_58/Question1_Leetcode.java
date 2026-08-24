package Day_58;
public class Question1_Leetcode {
    int val;
    Question1_Leetcode left;
    Question1_Leetcode right;
    Question1_Leetcode() {}
    Question1_Leetcode(int val) { this.val = val; }
    Question1_Leetcode(int val, Question1_Leetcode left, Question1_Leetcode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
 
class Solution {
    public int countNodes(Question1_Leetcode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getLeftHeight(Question1_Leetcode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }
    private int getRightHeight(Question1_Leetcode node) {
        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}