class Solution:
    def deleteNode(self, root, key):
        if root is None:
            return None

        # Search in the left subtree
        if key < root.val:
            root.left = self.deleteNode(root.left, key)

        # Search in the right subtree
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)

        # Node found
        else:
            # No left child
            if root.left is None:
                return root.right

            # No right child
            if root.right is None:
                return root.left

            # Two children:
            # Find smallest value in right subtree
            successor = root.right
            while successor.left:
                successor = successor.left

            root.val = successor.val
            root.right = self.deleteNode(root.right, successor.val)

        return root