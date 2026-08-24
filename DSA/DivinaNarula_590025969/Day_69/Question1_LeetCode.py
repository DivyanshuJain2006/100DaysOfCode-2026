# Construct Binary Search Tree from Preorder Traversal

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def bstFromPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: Optional[TreeNode]
        """
        self.index = 0

        def build(lower, upper):
            if self.index == len(preorder):
                return None

            val = preorder[self.index]

            if val < lower or val > upper:
                return None

            self.index += 1
            root = TreeNode(val)

            root.left = build(lower, val)
            root.right = build(val, upper)

            return root

        return build(float("-inf"), float("inf"))