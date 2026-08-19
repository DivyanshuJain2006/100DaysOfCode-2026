# Diameter of Binary Tree

class Solution(object):
    def diameterOfBinaryTree(self, root):
        diameter = [0]

        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            diameter[0] = max(diameter[0], left + right)

            return 1 + max(left, right)

        dfs(root)
        return diameter[0]