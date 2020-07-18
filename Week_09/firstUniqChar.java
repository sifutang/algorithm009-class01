class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - '0']++;
        }
        
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - '0'] == 1) {
                result = i;
                break;
            }
        }
        
        return result;
    }
}
