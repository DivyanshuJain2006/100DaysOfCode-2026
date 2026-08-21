# Balance a Binary Search Tree

class Solution(object):
    def balanceBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: Optional[TreeNode]
        """
        values = []
        stack = []
        current = root

        # Iterative inorder traversal gives sorted values
        while current or stack:
            while current:
                stack.append(current)
                current = current.left

            current = stack.pop()
            values.append(current.val)
            current = current.right

        # Construct a height-balanced BST
        def build(left, right):
            if left > right:
                return None

            mid = (left + right) // 2
            node = TreeNode(values[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)
            return node

        return build(0, len(values) - 1)