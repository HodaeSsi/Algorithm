class Node:
    def __init__(self, data, left_node, right_node): #init 메서드? self 키워드?
        self.data = data
        self.left_node = left_node
        self.right_node = right_node

def pre_order(node):
    print(node.data, end="")
    if node.left_node != '.':
        pre_order(tree[node.left_node]) #tree 글로벌 키워드 안해도 되네?
    if node.right_node != '.':
        pre_order(tree[right_node])

def in_order(node):
    if node.left_node != '.':
        in_order(tree[node.left_node])
    print(node.data, end="")
    if node.right_node != '.':
        in_order(tree[node.right_node])
    
def post_order(node):
    if node.left_node != '.':
        post_order(tree[node.left_node])
    if node.right_node != '.':
        post_order(tree[node.right_node])
    print(node.data, end="")
    
n = int(input())
tree = {} #왜 Dict? Dict말고 다른 방식은?
for i in range(n):
    data, left_node, right_node = input().split()
    tree[data] = Node(data, left_node, right_node)

pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])