class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0;
        int r = 0;
        String ans = "";

        while(l < word1.length() && r < word2.length()){
            ans += word1.charAt(l++);
            ans += word2.charAt(r++);
        }

        while(l < word1.length()){
            ans += word1.charAt(l++);
        }

        while(r < word2.length()) {
            ans += word2.charAt(r++);
        }
        return ans;
    }
}