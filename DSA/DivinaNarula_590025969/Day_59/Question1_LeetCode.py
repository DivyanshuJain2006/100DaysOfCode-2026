# Check Completeness of a Binary Tree

class Solution(object):
    def isCompleteTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        from collections import deque

        queue = deque([root])
        found_null = False

        while queue:
            node = queue.popleft()

            if node is None:
                found_null = True
            else:
                # Once NULL is found, no more nodes are allowed
                if found_null:
                    return False

                queue.append(node.left)
                queue.append(node.right)

        return True