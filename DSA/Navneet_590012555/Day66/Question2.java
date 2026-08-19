class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        inorder(root1, a);
        inorder(root2, b);

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j))
                ans.add(a.get(i++));
            else if (a.get(i) > b.get(j))
                ans.add(b.get(j++));
            else {
                ans.add(a.get(i));
                i++;
                j++;
            }
        }

        while (i < a.size())
            ans.add(a.get(i++));

        while (j < b.size())
            ans.add(b.get(j++));

        return ans;
    }

    void inorder(TreeNode root, ArrayList<Integer> a) {
        if (root == null)
            return;

        inorder(root.left, a);
        a.add(root.val);
        inorder(root.right, a);
    }
}
