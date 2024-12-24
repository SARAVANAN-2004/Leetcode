import java.util.*;

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dia1 = findDiameter(edges1);
        int dia2 = findDiameter(edges2);

        int radius1 = (dia1 + 1) / 2;
        int radius2 = (dia2 + 1) / 2;

        int sum = 1 + radius1 + radius2;
        return Math.max(sum, Math.max(dia1, dia2));
    }

    private int findDiameter(int[][] edges) {
        if (edges.length == 0) return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build adjacency list
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Pick an arbitrary starting node (first node from the edges)
        int startNode = edges[0][0];

        // First BFS to find the farthest node
        int[] farthestNodeInfo = bfs(startNode, adj);

        // Second BFS from the farthest node to calculate the diameter
        int[] diameterInfo = bfs(farthestNodeInfo[0], adj);

        return diameterInfo[1];
    }

    private int[] bfs(int start, Map<Integer, List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();

        queue.offer(start);
        visited.add(start);
        distance.put(start, 0);

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    distance.put(neighbor, distance.get(curr) + 1);

                    // Track the farthest node and its distance
                    if (distance.get(neighbor) > maxDistance) {
                        maxDistance = distance.get(neighbor);
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
