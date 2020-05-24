class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int base = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[base]) {
                base++;
                nums[base] = nums[i];
            }
        }
        
        return base + 1;
    }
}
