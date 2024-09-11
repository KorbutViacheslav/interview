package org.example;
import java.util.*;
public class DAGLongestPath {
    static final int MAX_NODES = 256;
    // Candidate function
    public static int findLongestPath(List<int[]> graph, int n) {
        // Initialize distance array to store the longest path length from each node
        int[] distance = new int[n];
        Arrays.fill(distance, 0);
        // Perform topological sort to process nodes in a dependency-safe order
        List<Integer> sorted = topologicalSort(graph, n);
        // Traverse the topologically sorted list and update distances
        for (int node : sorted) {
            for (int[] edge : graph) {
                if (edge[0] == node) {
                    distance[edge[1]] = Math.max(distance[edge[1]], distance[node] + 1);
                }
            }
        }
        // Find the maximum distance (longest path length)
        int maxDistance = 0;
        for (int d : distance) {
            maxDistance = Math.max(maxDistance, d);
        }
        return maxDistance;
    }
    // Function to perform topological sort using Kahn's Algorithm
    public static List<Integer> topologicalSort(List<int[]> graph, int n) {
        int[] inDegree = new int[n]; // Array to store in-degree of each node
        // Calculate in-degree of each node
        for (int[] edge : graph) {
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sorted = new ArrayList<>();
        // Add nodes with in-degree 0 to the queue (starting nodes)
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // Process nodes in the queue (topological order)
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sorted.add(node);
            for (int[] edge : graph) {
                if (edge[0] == node) {
                    inDegree[edge[1]]--;
                    if (inDegree[edge[1]] == 0) {
                        queue.add(edge[1]);
                    }
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{3, 4});
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        n++;
        int result = findLongestPath(edges, n);
        System.out.println(result);  // Виведе: 3
    }
}