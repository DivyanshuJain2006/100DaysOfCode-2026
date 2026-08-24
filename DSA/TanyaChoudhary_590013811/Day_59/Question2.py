from collections import Counter

def buildTree(arr):
    if not arr or arr[0] == -1:
        return None
    
    nodes = []
    for val in arr:
        if val == -1:
            nodes.append(None)
        else:
            nodes.append(TreeNode(val))
    
    for i in range(len(nodes)):
        if nodes[i] is None:
            continue
        left  = 2 * i + 1
        right = 2 * i + 2
        if left < len(nodes):
            nodes[i].left  = nodes[left]
        if right < len(nodes):
            nodes[i].right = nodes[right]
    
    return nodes[0]

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def canFormPalindrome(path):
    count = Counter(path)
    odd_count = sum(1 for c in count if count[c] % 2 != 0)
    return odd_count <= 1

def dfs(node, path, result):
    if not node:
        return
    
    path.append(str(node.val))
    
    if not node.left and not node.right:
        if canFormPalindrome(path):
            result[0] += 1
    
    dfs(node.left,  path, result)
    dfs(node.right, path, result)
    
    path.pop()

def secretPasscodes(arr):
    root = buildTree(arr)
    result = [0]
    dfs(root, [], result)
    return result[0]

print(secretPasscodes([1,2,3,1,1,-1,3]))
print(secretPasscodes([1,2,3,4,5,-1,6]))