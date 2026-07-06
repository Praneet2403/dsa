class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }

        // int[][] dist= new int[n][m];

        // for(int i = 0; i< n; i++) {
        //     for(int j = 0 ; j<m; j++) {
        //         dist[i][j] = (int)(1e9);
        //     }
        // }

        int[][] direction = {
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r  = curr[0];
            int c = curr[1];
            int len = curr[2];

            if(r == n-1 && c == n-1) {
                return len;
            }

            for(int[] dir : direction) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < n && nr >= 0 && nc <n && nc>=0 && grid[nr][nc] == 0) {
                    q.offer(new int[]{nr,nc,len+1});
                    grid[nr][nc] =1;
                }
            }
        }
        return -1;
    }
}