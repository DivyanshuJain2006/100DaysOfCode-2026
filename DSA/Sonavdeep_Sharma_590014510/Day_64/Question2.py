class Solution:
    def lowestCommonAncestor(self, root: TreeNode, a: int, b: int) -> TreeNode:
        if a < root.val and b < root.val:
            return self.lowestCommonAncestor(root.left, a, b)

        if a > root.val and b > root.val:
            return self.lowestCommonAncestor(root.right, a, b)

        return root