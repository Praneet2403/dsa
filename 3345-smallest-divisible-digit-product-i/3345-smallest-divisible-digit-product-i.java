class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int mul = 1;
            int m = n;

            while (m > 0) {
                int digit = m % 10;
                mul *= digit;
                m /= 10;
            }

            if (mul % t == 0) {
                return n;
            }

            n++;
        }
    }
}