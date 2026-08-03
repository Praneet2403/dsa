class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i =i;
        this.j = j;
    }
}
class Solution {
    
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;

        Map<String , List<Pair>> mp = new HashMap<>();

        for(int i =0; i< n; i++) {
            for(int j=i+1; j < n; j++) {
                int midx = points[i][0] + points[j][0];
                int midy = points[i][1] + points[j][1];

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int dist = dx*dx + dy * dy;


                String key = midx + "#" + midy + "#" + dist;

                mp.computeIfAbsent(key , k -> new ArrayList<>()).add(new Pair(i,j));

            }
        }

        double ans = Double.MAX_VALUE;

        for(List<Pair> list :mp.values()){

            int m = list.size();


            for(int i = 0; i< m; i++) {
                for(int j = i+1; j< m; j++) {
                    Pair p1 = list.get(i);
                    Pair p2 = list.get(j);

                    int[] A = points[p1.i];
                    int[] B = points[p1.j];
                    int[] C = points[p2.i];

                    double side1 = distance(A, C);
                    double side2 = distance(B, C);

                    ans = Math.min(ans, side1 * side2);
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0.0 : ans;

    }

    public double distance(int[] a, int[] b) {
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }




}