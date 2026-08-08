class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<=n ; i++) {
            adj.add(new ArrayList<>());
        }


        for(int[] e : edges){
            int a = e[0];
            int b = e[1];

            if(isConnected(a, b, adj, n)) {
                return e;
            }

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        return new int[0];
    }

    public boolean isConnected(int a , int b, List<List<Integer>> adj, int n) {
        boolean[] vis = new boolean[n + 1];
        Stack<Integer> st = new Stack<>();
        st.push(a);

        while (!st.isEmpty()) {

            int node = st.pop();

            if (node == b) {
                return true;
            }

            if (vis[node]) {
                continue;
            }

            vis[node] = true;

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    st.push(neighbor);
                }
            }

        }
        return false;
    }
}