import java.util.*;

class Solution {
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        
        inorder(root1, a);
        inorder(root2, b);
        
        List<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != a.get(i))
                    ans.add(a.get(i));
                i++;
            } 
            else if (a.get(i) > b.get(j)) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != b.get(j))
                    ans.add(b.get(j));
                j++;
            } 
            else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != a.get(i))
                    ans.add(a.get(i));
                i++;
                j++;
            }
        }
        
        while (i < a.size()) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != a.get(i))
                ans.add(a.get(i));
            i++;
        }
        
        while (j < b.size()) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != b.get(j))
                ans.add(b.get(j));
            j++;
        }
        
        return ans;
    }
    
    void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
