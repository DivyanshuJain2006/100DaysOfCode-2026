from collections import deque

class Solution:
    def isCompleteTree(self, root):
        q = deque([root])
        found_none = False

        while q:
            node = q.popleft()

            if node is None:
                found_none = True
            else:
                if found_none:
                    return False

                q.append(node.left)
                q.append(node.right)

        return True