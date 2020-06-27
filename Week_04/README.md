学习笔记

## DFS
示例代码
```
fun dfs(node) {
    if (node in visited) {
        return;
    }
    
    visited.add(node);
    
    // process current node
    dfs(node.left);
    dfs(node.right);
}
```

```
visited = set()
def dsf(node, visited):
    if node in visited:
        return
    
    visited.add(node)
    // process
    for next_node in node.child:
        if not next_node in visited:
            dfs(next_node, visited)
```

## BFS
```
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while quue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```

## 贪心算法
贪心算法是一种在每一步选择中都采取当前状态下的最优解，从而希望达到全局最优的算法。
即：采用局部最优解来求全局最优解，存在局限性，局部最优不一定就全局最优

贪心算法可以解决一些最优化问题，如：求图中的最小生成树，求哈夫曼编码等

贪心算法与动态规划的不同：
1. 贪心算法对于子问题作出选择后，不进行回退
2. 动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能

## 二分查找
二分查找的前提：
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界
3. 能够通过索引访问

代码模板：
```
left = 0;
right = arr.length() - 1
while (left <= right) {
    mid = (left + right) / 2
    if (arr[mid] == target) {
        break or return result
    }
    
    if (arr[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```


