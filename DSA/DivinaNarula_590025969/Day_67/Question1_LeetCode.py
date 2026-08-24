# Delete Node in a BST

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: Optional[TreeNode]
        :type key: int
        :rtype: Optional[TreeNode]
        """

        # If tree is empty
        if root is None:
            return None

        # Search for the key
        if key < root.val:
            root.left = self.deleteNode(root.left, key)

        elif key > root.val:
            root.right = self.deleteNode(root.right, key)

        else:
            # Case 1: No left child
            if root.left is None:
                return root.right

            # Case 2: No right child
            if root.right is None:
                return root.left

            # Case 3: Two children
            # Find smallest value in right subtree
            successor = root.right
            while successor.left:
                successor = successor.left

            # Replace current node's value
            root.val = successor.val

            # Delete the successor
            root.right = self.deleteNode(root.right, successor.val)

        return root