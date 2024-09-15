package org.example;

import java.util.*;

public class DAGLongestPathTraining {
    // Максимальна кількість вузлів (може бути змінена за потреби)
    static final int MAX_NODES = 256;

    // Функція для знаходження найдовшого шляху в DAG
    public static int findLongestPath(List<int[]> graph, int n) {
        // Створимо масив для зберігання довжини найдовшого шляху до кожного вузла
        // Спочатку ініціалізуємо всі значення нулем
        int[] distance = new int[n];
        // Заповнюємо нулями всі значення в масиві
        Arrays.fill(distance, 0);
        System.out.println(Arrays.toString(distance));

        // Виконаємо топологічне сортування графу для обходу вузлів у правильному порядку
        List<Integer> sorted = topologicalSort(graph, n);

        // Пройдемося по відсортованих вузлах
        for (int node : sorted) {
            // Перевіримо всі ребра, що виходять з поточного вузла
            for (int[] edge : graph) {
                // Якщо перший елемент ребра (початковий вузол) збігається з поточним вузлом
                if (edge[0] == node) {
                    // Розрахуємо потенційну довжину шляху до кінцевого вузла ребра
                    // і оновимо значення в масиві відстаней, якщо новий шлях довший
                    distance[edge[1]] = Math.max(distance[edge[1]], distance[node] + 1);
                }
            }
        }
        // Знайдемо максимальну відстань серед усіх розрахованих
        int maxDistance = 0;
        for (int d : distance) {
            maxDistance = Math.max(maxDistance, d);
        }
        // Повернемо довжину найдовшого шляху
        return maxDistance;
    }

    // Функція для виконання топологічного сортування графу за алгоритмом Кана
    public static List<Integer> topologicalSort(List<int[]> graph, int n) {
        // Створимо масив для зберігання вхідного ступеня кожного вузла
        int[] inDegree = new int[n];
        for (int[] edge : graph) {
            inDegree[edge[1]]++; // Збільшуємо вхідний ступінь кінцевого вузла ребра
        }
        System.out.println("\nВхідний ступінь після обчислення:");
        for (int i = 0; i < n; i++) {
            System.out.println("Вузол " + i + ": " + inDegree[i]);
        }
        // Створимо чергу та список для результату
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sorted = new ArrayList<>();

        // Додамо до черги всі вузли з вхідним ступенем 0 (початкові вузли)
        System.out.println("\nДодаємо до черги вузли з вхідним ступенем 0:");
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                System.out.println("Вузол " + i + " додано до черги.");
            }
        }

        // Поки черга не порожня
        while (!queue.isEmpty()) {
            // Виймаємо з черги вузол
            int node = queue.poll();
            System.out.println("\nВузол " + node + " видалено з черги.");
            // Додаємо його до списку відсортованих вузлів
            sorted.add(node);
            System.out.println("Вузол " + node + " додано до відсортованого списку.");

            // Перевіримо всі ребра, що виходять з поточного вузла
            for (int[] edge : graph) {
                if (edge[0] == node) {
                    // Зменшуємо вхідний ступінь кінцевого вузла ребра
                    inDegree[edge[1]]--;
                    System.out.println("Вхідний ступінь вузла " + edge[1] + " зменшено до " + inDegree[edge[1]]);

                    // Якщо вхідний ступінь став нулем, додаємо вузол до черги
                    if (inDegree[edge[1]] == 0) {
                        queue.add(edge[1]);
                        System.out.println("Вузол " + edge[1] + " додано до черги, бо його вхідний ступінь став 0.");
                    }
                }
            }
        }

        // Повернемо список відсортованих вузлів
        System.out.println("\nВідсортований список вузлів (топологічний порядок): " + sorted);
        return sorted;
    }

    // Головна функція для тестування
    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 5},
                new int[]{2, 3},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{4, 6},
                new int[]{3, 5});
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        n++;
        int result = findLongestPath(edges, n);
        System.out.println(result);
    }
}
