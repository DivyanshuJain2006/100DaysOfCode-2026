class Solution {
    List<Integer> al = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        traversalValue(root1, r1);
        traversalValue(root2, r2);

        for (int i = 0; i < r1.size(); i++) {
            al.add(r1.get(i));
        }

        for (int i = 0; i < r2.size(); i++) {
            al.add(r2.get(i));
        }

        Collections.sort(al);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < al.size(); i++) {
            if (i == 0 || !al.get(i).equals(al.get(i - 1))) {
                result.add(al.get(i));
            }
        }

        return result;
    }

    public void traversalValue(TreeNode root, List<Integer> r) {

        if (root == null) {
            return;
        }

        traversalValue(root.left, r);
        r.add(root.val);
        traversalValue(root.right, r);
    }
}