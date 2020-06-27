学习笔记

动态规划和递归或者分治没有根本上的区别（关键看有无最优的i子结构）
共性：找到重复子问题
差异性：最优子结构，中途可以淘汰次优解

## 递归代码模板
```
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level + 1, newParam);
    
    // restore current status
}

```

## 分治代码模板
```
def divide_conquer(problem, param1, param2,...):
    # recursion termimnator
    if problem is None:
        print_result
        return
        
    # perpare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
    ...
    
    # proces and generate the final result
    result = proces_result(subresult1, subresult2, subresult13,...)
    
    # revert the current level states
```

## 动态规划关键点
1. 最优子结构 opt[n] = best_of(opt[n -1], opt[n - 2], ....)
2. 存储中间状态: opt[i]
3. 状态转移方程
    Fib: opt[i] = opt[n - 1] + opt[n - 2]
    二维路径问题: opt[i, j] = opt[i + 1, j] + opt[i, j + 1] (且判断opt[i, j] 是否为空地)
