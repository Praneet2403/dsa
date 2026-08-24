class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = Arrays.stream(piles).sum();

        int n = piles.length;

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int a = solve(0, n - 1, piles, dp);

        return a > sum / 2;
    }

    public int solve(int i, int j, int[] piles, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int takei = piles[i] + Math.min(solve(i + 2, j, piles, dp), solve(i + 1, j - 1, piles, dp));
        int takej = piles[j] + Math.min(solve(i, j - 2, piles, dp), solve(i + 1, j - 1, piles, dp));

        return dp[i][j] = Math.max(takei, takej);
    }
}