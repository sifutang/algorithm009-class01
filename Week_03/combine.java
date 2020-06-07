class Solution {
    List<List<Integer>> output = new LinkedList();
    
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new LinkedList<Integer>());
        return output;
    }
    
    private void helper(int n, int k, int level, LinkedList<Integer> current) {
        if (current.size() == k) {
            output.add(new LinkedList(current));
        }
        
        for (int i = level; i <= n; i++) {
            current.add(i);
            helper(n, k, i + 1, current);
            current.removeLast();
        }
    }
}
