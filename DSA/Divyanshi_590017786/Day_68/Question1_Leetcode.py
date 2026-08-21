class Solution:
    def balanceBST(self, root):
        values = []

        def inorder(node):
            if node is None:
                return

            inorder(node.left)
            values.append(node.val)
            inorder(node.right)

        def build(left, right):
            if left > right:
                return None

            mid = (left + right) // 2

            node = TreeNode(values[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)

            return node

        inorder(root)

        return build(0, len(values) - 1)