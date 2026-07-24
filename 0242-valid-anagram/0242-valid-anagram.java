class Solution {
    public boolean isAnagram(String s, String t) {
        // HashSet<Character> hs = new HashSet<>();
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}