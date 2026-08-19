class Solution:
    def findMode(self, root):
        result = []
        self.prev = None
        self.count = 0
        self.max_count = 0

        def inorder(node):
            if node is None:
                return

            inorder(node.left)

            if self.prev == node.val:
                self.count += 1
            else:
                self.count = 1

            if self.count > self.max_count:
                self.max_count = self.count
                result.clear()
                result.append(node.val)
            elif self.count == self.max_count:
                result.append(node.val)

            self.prev = node.val

            inorder(node.right)

        inorder(root)

        return result