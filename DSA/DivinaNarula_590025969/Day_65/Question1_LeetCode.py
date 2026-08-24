class Solution(object):
    def findMode(self, root):
        result = []
        values = []

        def inorder(node):
            if not node:
                return

            inorder(node.left)
            values.append(node.val)
            inorder(node.right)

        inorder(root)

        max_count = 0

        for i in range(len(values)):
            count = values.count(values[i])

            if count > max_count:
                max_count = count
                result = [values[i]]
            elif count == max_count and values[i] not in result:
                result.append(values[i])

        return result