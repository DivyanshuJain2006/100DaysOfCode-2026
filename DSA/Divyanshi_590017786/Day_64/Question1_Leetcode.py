class Solution:
    def rangeSumBST(self, root, low, high):
        if root is None:
            return 0

        # If value is smaller than range,
        # only search the right subtree
        if root.val < low:
            return self.rangeSumBST(root.right, low, high)

        # If value is larger than range,
        # only search the left subtree
        if root.val > high:
            return self.rangeSumBST(root.left, low, high)

        # Value is inside the range
        return (root.val +
                self.rangeSumBST(root.left, low, high) +
                self.rangeSumBST(root.right, low, high))