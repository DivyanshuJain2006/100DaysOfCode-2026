class Solution:
    def isCompleteTree(self, root):
        if not root:
            return True
        
        queue = [root]
        found_none = False
        
        while queue:
            node = queue.pop(0)
            
            if node is None:
                found_none = True
            else:
                if found_none:
                    return False
                queue.append(node.left)
                queue.append(node.right)
        
        return True