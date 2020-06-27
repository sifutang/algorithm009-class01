class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                         word -> {
                             for (int i = 0; i < L; i++) {
                                 String newWorld = world.substring(0, i) + "*" + word.substring(i + 1, L);
                                 List<String> transformations = allComboDict.getOrDefault(newWorld, new ArrayList<>());
                                 transformations.add(word);
                                 allComboDict.put(newWorld, transformations);
                             }
                         }
        )
        
    }
}
