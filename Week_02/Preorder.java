/*
 // Definition for a Node.
 class Node {
 public int val;
 public List<Node> children;
 
 public Node() {}
 
 public Node(int _val) {
 val = _val;
 }
 
 public Node(int _val, List<Node> _children) {
 val = _val;
 children = _children;
 }
 };
 */

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        helper(root, res);
        return res;
    }
    
    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        int size = root.children != null ? root.children.size() : 0;
        for (int i = 0; i < size; i++) {
            Node node = root.children.get(i);
            if (root != null) {
                helper(node, res);
            }
        }
    }
}
