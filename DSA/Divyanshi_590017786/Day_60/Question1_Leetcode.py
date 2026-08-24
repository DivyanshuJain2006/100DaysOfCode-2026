class Solution:
    def diameterOfBinaryTree(self, root):
        self.diameter = 0

        def height(node):
            if node is None:
                return 0

            left = height(node.left)
            right = height(node.right)

            self.diameter = max(self.diameter, left + right)

            return 1 + max(left, right)

        height(root)
        return self.diameter