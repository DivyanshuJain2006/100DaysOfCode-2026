# Count Complete Tree Nodes

class Solution(object):
    def countNodes(self, root):
        if not root:
            return 0

        def leftHeight(node):
            height = 0
            while node:
                height += 1
                node = node.left
            return height

        def rightHeight(node):
            height = 0
            while node:
                height += 1
                node = node.right
            return height

        left = leftHeight(root)
        right = rightHeight(root)

        if left == right:
            return (1 << left) - 1

        return 1 + self.countNodes(root.left) + self.countNodes(root.right)