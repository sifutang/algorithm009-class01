class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return res;
    }
}
