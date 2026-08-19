class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None

def lca(root,a,b):
    while root:
        if a<root.value and b<root.value:
            root=root.left
        elif a>root.value and b>root.value:
            root=root.right
        else:
            return root.value

root=Node(6)
root.left=Node(2)
root.right=Node(8)
root.left.left=Node(0)
root.left.right=Node(4)
root.right.left=Node(7)
root.right.right=Node(9)
a=2
b=8
print("Lowest Common Ancestor:", lca(root,a,b))

