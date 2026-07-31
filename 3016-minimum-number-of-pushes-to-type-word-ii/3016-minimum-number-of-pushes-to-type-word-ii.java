class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];

        for(int i =0; i< n; i++) {
            freq[word.charAt(i) - 'a']++;
        }


        Arrays.sort(freq);
        int cnt = 0;

        for(int i = 25 ; i>= 0; i--){
            if(freq[i] ==0) {
                break;
            }

            int rank = 25 - i; 
            int pushesPerChar = (rank / 8) + 1;
            
            cnt += freq[i] * pushesPerChar;
        }

        return cnt;
    }
}