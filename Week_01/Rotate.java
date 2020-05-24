class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }
        
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        if (start >= end) {
            return;
        }
        
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            
            start++;
            end--;
        }
    }
}
