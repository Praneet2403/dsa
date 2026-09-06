class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    cnt++;
                    vis[i][j] = 1;
                    q.add(new Pair(i, j));

                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        int row = p.first;
                        int col = p.second;

                        for (int k = 0; k < 4; k++) {
                            int nrow = row + dx[k];
                            int ncol = col + dy[k];

                            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1' ) {
                                vis[nrow][ncol] = 1;
                                q.add(new Pair(nrow, ncol));

                            }
                        }

                    }

                }
            }
        }
        return cnt;

    }
}