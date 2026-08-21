class Solution:
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        arr = []

        def inorder(node):
            if node:
                inorder(node.left)
                arr.append(node.val)
                inorder(node.right)

        inorder(root)

        def build(left, right):
            if left > right:
                return None

            mid = (left + right) // 2

            node = TreeNode(arr[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)

            return node

        return build(0, len(arr) - 1)