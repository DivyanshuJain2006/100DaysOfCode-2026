class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def buildTree(level_order):
    if not level_order or level_order[0] == -1:
        return None
    
    root = TreeNode(level_order[0])
    queue = [root]
    i = 1
    
    while queue and i < len(level_order):
        node = queue.pop(0)
        
        if i < len(level_order) and level_order[i] != -1:
            node.left = TreeNode(level_order[i])
            queue.append(node.left)
        i += 1
        
        if i < len(level_order) and level_order[i] != -1:
            node.right = TreeNode(level_order[i])
            queue.append(node.right)
        i += 1
    
    return root

def exists(root, val):
    if not root:
        return False
    if root.val == val:
        return True
    return exists(root.left, val) or exists(root.right, val)

def lca(root, p, q):
    if not root:
        return None
    if root.val == p or root.val == q:
        return root
    
    left  = lca(root.left, p, q)
    right = lca(root.right, p, q)
    
    if left and right:
        return root
    
    return left if left else right

def disputeResolution(level_order, emp1, emp2):
    root = buildTree(level_order)
    
    if not exists(root, emp1) or not exists(root, emp2):
        return -1
    
    result = lca(root, emp1, emp2)
    return result.val if result else -1

print(disputeResolution([3,5,1,6,2,0,8,-1,-1,7,4], 5, 1))
print(disputeResolution([3,5,1,6,2,0,8,-1,-1,7,4], 5, 4))
print(disputeResolution([3,5,1,6,2,0,8,-1,-1,7,4], 5, 99))