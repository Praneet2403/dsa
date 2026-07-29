class Solution {
    public long nCr(int n, int r, int k) {
        //nCr == nC(n-r)
        r = Math.min(r, n - r);

        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i);
            result /= i;

            if (result >= k)
                return k;
        }
        return result;
    }

    public String smallestPalindrome(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();
        char mid = '\0';
        if (n % 2 == 1) {
            mid = arr[n / 2];
        }

        int[] freq = new int[26];

        for (int i = 0; i < arr.length; i++) {
            if (n % 2 == 1 && i == n / 2)
                continue; //skip mid
            freq[arr[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        StringBuilder halfRes = new StringBuilder();
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            boolean flag = false;
            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j]--;
                    //no. of ways;

                    long ways = 1;
                    int letters = 0;
                    for (int c = 0; c < 26; c++) {
                        letters += freq[c];
                    }

                    for (int c = 0; c < 26; c++) {
                        if (freq[c] > 0) {
                            ways *= nCr(letters, freq[c], k);
                            if (ways >= k) {
                                ways = k;
                                break;
                            }
                            letters -= freq[c];
                        }
                    }

                    if (k <= ways) {

                        halfRes.append((char) (j + 'a'));
                        flag = true;
                        break;

                    }

                    k -= ways;
                    freq[j]++;
                }
            }
            if (flag == false) {
                return "";
            }
        }

        // String rev = halfRes;

        String rev = new StringBuilder(halfRes).reverse().toString();
        if (mid != '\0') {
            halfRes.append(mid);
        }
        return halfRes.toString() + rev;
    }
}