order = 0

class Node:
    def __init__(self, data, left_node, right_node, level = 0, order = 0):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node
        self.level = level
        self.order = order
    
    def returnInfo(self):
        return (self.level, self.order)

def in_order(node, level):
    #node.level = level
    tree[node.data].level = level
    if node.left_node != '-1':
        in_order(tree[node.left_node], level + 1)
    global order
    order += 1
    tree[node.data].order = order
    if node.right_node != '-1':
        in_order(tree[node.right_node], level + 1)
    

N = int(input())
tree = {}

primeNode, c1, c2 = input().split(" ")
tree[primeNode] = Node(primeNode, c1, c2)
for i in range(1, N, 1):
    p, c1, c2 = input().split(" ")
    tree[p] = Node(p, c1, c2)

in_order(tree[primeNode], 1)
nodeDict = {}

for i in tree.keys():
    l, o = tree[i].returnInfo()
    if l not in nodeDict:
        nodeDict[l] = [o]
    else:
        nodeDict[l].append(o)

widthList = []
for i in nodeDict.keys():
    width = max(nodeDict[i]) - min(nodeDict[i]) + 1
    widthList.append((int(i), width))

widthList.sort(key=lambda x: (-x[1], x[0])) #https://dailyheumsi.tistory.com/67 복잡한 조건의 sort
print(widthList[0][0], widthList[0][1])

    

