class Solution {
    public void isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        if (sArr.length != tArr.length) {
            return false;
        }
        
        int[] table1 = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            table1[sArr[i] - 'a']++;
        }
        
        int[] table2 = new int[26];
        for (int i = 0; i < tArr.length; i++) {
            table2[tArr[i] - 'a']++;
        }
        
        for (int i = 0; i < table1.length; i++) {
            if (table1[i] != table2[i]) {
                return false;
            }
        }
        
        return true;
    }
}
