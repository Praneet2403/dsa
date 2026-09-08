class Solution {
    public String minWindow(String s, String t) {
        Map<Character , Integer> mp = new HashMap<>();

        for( char c : t.toCharArray()) {
            mp.put(c , mp.getOrDefault(c , 0) + 1);
        }
        
        int left = 0;
        int right =0;

        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if(mp.containsKey(ch)) {
                if(mp.get(ch) > 0) {
                    count--;
                }
                mp.put(ch , mp.get(ch) - 1);
            }

            while(count == 0) {
                if(minLen > right - left +1) {
                    minLen = right - left +1;
                    startIdx = left;
                }
                
                if(mp.containsKey(s.charAt(left))) {
                    mp.put(s.charAt(left) , mp.get(s.charAt(left)) + 1);

                    if(mp.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
            right++;
        }
         if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIdx, startIdx + minLen);
    }
}