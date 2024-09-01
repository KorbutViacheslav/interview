import java.util.*;

public class DAGLongestPath {
    static final int MAX_NODES = 256;

    // Candidate function
    public static int findLongestPath(List<int[]> graph, int n) {
        // Ініціалізуємо граф і масив для зберігання кількості входів у вершини (in-degree)
        List<List<Integer>> adjList = new ArrayList<>(MAX_NODES);
        int[] inDegree = new int[MAX_NODES];
        for (int i = 0; i < MAX_NODES; i++) {
            adjList.add(new ArrayList<>());
        }
        // Заповнюємо граф та рахуємо in-degree для кожної вершини
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            inDegree[v]++;
        }
        // Знаходимо топологічне сортування
        List<Integer> topologicalOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // Ініціалізуємо масив для зберігання довжини найдовшого шляху до кожної вершини
        int[] longestPath = new int[MAX_NODES];

        // Обходимо вершини в топологічному порядку
        for (int node : topologicalOrder) {
            for (int neighbor : adjList.get(node)) {
                if (longestPath[neighbor] < longestPath[node] + 1) {
                    longestPath[neighbor] = longestPath[node] + 1;
                }
            }
        }
        // Знаходимо максимальне значення з longestPath масиву
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (longestPath[i] > maxLength) {
                maxLength = longestPath[i];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{3, 4}
        );

        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        n++;

        int result = findLongestPath(edges, n);
        System.out.println(result);  // Виведе: 3
    }
}