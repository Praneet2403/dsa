class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();


        int[] pCnt = new int[26];
        int[] khidki = new int[26];
        for(char c: p.toCharArray()) {
            pCnt[c - 'a']++;
        }
        
        int low = 0;
        for(int right = 0; right< s.length(); right++) {
            khidki[s.charAt(right) - 'a']++;

            if(right - low +1 > p.length()) {
                khidki[s.charAt(low++) - 'a']--;
            }
            if(Arrays.equals(pCnt,khidki)){
                list.add(low);            
            }

        }
        return list;
    }
}