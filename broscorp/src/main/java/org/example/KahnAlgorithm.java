package org.example;

import java.util.*;

//Топологічне сортування графу за алгоритмом Кана
public class KahnAlgorithm {
    public static void topologicalSort(Map<Integer, List<Integer>> graph) {
        // Степень захода каждой вершины
        int[] indegree = new int[graph.size()];
        for (List<Integer> neighbors : graph.values()) {
            for (int neighbor : neighbors) {
                indegree[neighbor]++;
            }
        }

        // Очередь для вершин со степенью захода 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Топологически отсортированный список
        List<Integer> topologicalOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);

            for (int neighbor : graph.getOrDefault(node,
                    Collections.emptyList())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Если граф имеет циклы, не все вершины будут добавлены в очередь
        if (topologicalOrder.size() != graph.size()) {
            System.out.println("Граф содержит циклы");
        } else {
            System.out.println("Топологическая сортировка: " + topologicalOrder);
        }
    }

    public static void main(String[] args) {
        // Пример графа:
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3));
        graph.put(4, Arrays.asList(0, 1));

        topologicalSort(graph);
    }
}
