# Insert into a Binary Search Tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def insertIntoBST(self, root, val):
        """
        :type root: Optional[TreeNode]
        :type val: int
        :rtype: Optional[TreeNode]
        """

        # If tree is empty, new node becomes the root
        if root is None:
            return TreeNode(val)

        current = root

        while True:
            # New value belongs in the right subtree
            if val > current.val:
                if current.right is None:
                    current.right = TreeNode(val)
                    break
                current = current.right

            # New value belongs in the left subtree
            else:
                if current.left is None:
                    current.left = TreeNode(val)
                    break
                current = current.left

        return root