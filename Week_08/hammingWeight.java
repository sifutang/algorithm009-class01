public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return helper(n);
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    
    private int helper(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        
        return count;
    }
}
