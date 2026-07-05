import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] outDegree = new int[n];

        for (int from = 0; from < n; from++) {
            for (int to : graph[from]) {
                reverseGraph.get(to).add(from);
                outDegree[from]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] isSafe = new boolean[n];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            isSafe[current] = true;

            for (int prev : reverseGraph.get(current)) {
                outDegree[prev]--;
                if (outDegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
