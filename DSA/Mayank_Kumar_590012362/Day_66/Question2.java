class Solution {
    void f(TreeNode r, ArrayList<Integer> a) {
        if (r == null) return;
        f(r.left, a);
        a.add(r.val);
        f(r.right, a);
    }
    ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() || j < b.size()) {
            int x = i < a.size() ? a.get(i) : Integer.MAX_VALUE;
            int y = j < b.size() ? b.get(j) : Integer.MAX_VALUE;
            int v = Math.min(x, y);
            if (c.isEmpty() || c.get(c.size() - 1) != v) c.add(v);
            while (i < a.size() && a.get(i) == v) i++;
            while (j < b.size() && b.get(j) == v) j++;
        }
        return c;
    }
    ArrayList<Integer> getAll(TreeNode a, TreeNode b) {
        ArrayList<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        f(a, x);
        f(b, y);
        return merge(x, y);
    }
}