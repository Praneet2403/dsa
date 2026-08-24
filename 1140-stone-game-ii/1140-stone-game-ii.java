class Solution {
    public int stoneGameII(int[] piles) {

        int[][][] dp = new int[2][piles.length][piles.length +1];

        for(int p=0;p<2;p++) {
            for(int i=0;i<piles.length;i++) {
                Arrays.fill(dp[p][i] , -1);
            }
        }
        
        return alice(piles, 1,0,1,dp);
    }

    public int alice(int[] piles, int person, int i, int m , int[][][] dp) {
        if(i >= piles.length) return 0;

        if(dp[person][i][m] != -1) {
            return dp[person][i][m];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stone = 0;

        for(int x = 1 ; x <= Math.min(piles.length-i , 2*m); x++) {
            stone += piles[i + x -1];
            if(person ==1) {
                result = Math.max(result, stone + alice(piles , 0 , i+x , Math.max(m , x), dp));
            } else {
                result = Math.min(result , alice(piles, 1, x+i, Math.max(m ,x) , dp) );
            }
        }
        return dp[person][i][m] = result;
    }
}