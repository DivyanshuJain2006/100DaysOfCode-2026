class Solution {
    public TreeNode bstFromPreorder(int[] a) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode r = new TreeNode(a[0]);
        s.push(r);
        for (int i = 1; i < a.length; i++) {
            TreeNode n = new TreeNode(a[i]);
            if (a[i] < s.peek().val) s.peek().left = n;
            else {
                TreeNode p = null;
                while (!s.empty() && a[i] > s.peek().val) p = s.pop();
                p.right = n;
            } s.push(n);
        } return r;
    }
}