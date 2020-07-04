学习笔记

## 字典树
即Trie树，又称单词查找树或键树，是一种树形结构  

典型应用于t统计和排序大量的字符串（不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。  

优点：最大限度的减少无谓的字符串比较，查询效率比哈希表高

基本性质
1. 节点本身不存储单词；
2. 从根节点到某一节点，路径上经过的字符连接起来（边存储字符），为该节点对应的字符串；
3. 每个节点的所有子节点路径代表的字符都是不相同的

核心思想
1. 空间换时间；
2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

Java实现
```
class Trie {

    private TrieNode trieNode;
    /** Initialize your data structure here. */
    public Trie() {
        trieNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        TrieNode node = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                node.put(curr, new TrieNode());
            }

            node = node.get(curr);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefx(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefx(prefix);
        return node != null;
    }

    private TrieNode searchPrefx(String word) {
        TrieNode node = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {
    private TrieNode[] links;
    private int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/
```

## 并查集
适用场景：组团，配对问题

基本操作：

makeSet(s): 建立一个新的并查集，其中包含s个单元素集合

unionSet(x, y):  把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并

find(x): 找到元素x所在的集合的代表，也可用于判断两个元素是否在同一个集合

```
class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }   
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
```

## 高级搜索
### 初级搜索：
1. 朴素搜索
2. 优化方式：不重复（fibonacci），剪枝（生成括号问题）
3. 搜索方向：DFS，BFS

### 高级搜索
1.  剪枝
2. 双向BFS
3. 启发式搜索

## AVL树和红黑树
### AVL树
平衡二叉搜索树

Balance Factor: {-1, 0, 1} 左子树的高度减去它的右子树的高度（有时相反）

通过旋转操作来进行平衡：左旋，右旋，左右旋，右左旋

不足：节点需要存储额外信息，且调整次数频繁

### 红黑树
近似平衡的二叉搜索树，它能确保任何一个节点的左右子树的高度差小于2倍

特点：  

1. 每个节点要么红色，要么黑色；
2. 根节点是黑色的；
3. 每个叶节点是黑色的；
4. 不能有相邻接的两个红色节点；
5. 从任一节点到其它每个叶子的所有路径都包含相同数目的黑色节点



