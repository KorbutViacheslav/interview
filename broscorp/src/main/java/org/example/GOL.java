package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GOL {
    // Кількість рядків у сітці.
    private int rows;

    // Кількість стовпців у сітці.
    private int cols;

    // Кількість ітерацій симуляції.
    private int iterations;

    //Двовимірний масив, що представляє стан кожної клітинки.true - жива клітинка, false - мертва.
    private boolean[][] grid;

    /**
     * Головний метод, який ініціює гру.
     *
     * @param fileNameInput  Ім'я вхідного файлу з початковим станом сітки.
     * @param fileNameOutput Ім'я вихідного файлу для збереження кінцевого стану сітки.
     */
    public void game(String fileNameInput, String fileNameOutput) {
        try {
            // Зчитуємо початковий стан сітки з вхідного файлу.
            readInputFile(fileNameInput);

            // Симулюємо гру задану кількість ітерацій.
            simulateLife();

            // Записуємо кінцевий стан сітки у вихідний файл.
            writeOutputFile(fileNameOutput);
        } catch (IOException e) {
            System.err.println("Помилка вводу-виводу: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println("Помилка URI: " + e.getMessage());
        }
    }

    /**
     * Зчитує початковий стан сітки з вхідного файлу.
     *
     * @param fileName Ім'я вхідного файлу.
     * @throws IOException Якщо виникла помилка під час читання файлу.
     */
    private void readInputFile(String fileName) throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            // Зчитуємо розміри сітки та кількість ітерацій з першого рядку.
            String[] dimensions = br.readLine().split(",");
            rows = Integer.parseInt(dimensions[0]);
            cols = Integer.parseInt(dimensions[1]);
            iterations = Integer.parseInt(dimensions[2]);

            // Ініціалізуємо сітку заданими розмірами.
            grid = new boolean[rows][cols];

            // Зчитуємо початковий стан кожної клітинки з решти рядків.
            for (int i = 0; i < rows; i++) {
                String line = br.readLine();
                String[] cells = line.split(" ");
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = cells[j].equals("X");
                }
            }
        }
    }

    /**
     * Симулює гру "Життя" задану кількість ітерацій.
     */
    private void simulateLife() {
        for (int generation = 0; generation < iterations; generation++) {
            // Створюємо нову сітку для наступного покоління.
            boolean[][] newGrid = new boolean[rows][cols];

            // Перебираємо всі клітинки сітки.
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    // Підраховуємо кількість живих сусідів для поточної клітинки.
                    int liveNeighbors = countLiveNeighbors(row, col);

                    // Застосовуємо правила "Життя" для визначення нового стану клітинки.
                    if (grid[row][col]) {
                        newGrid[row][col] = liveNeighbors == 2 || liveNeighbors == 3;
                    } else {
                        newGrid[row][col] = liveNeighbors == 3;
                    }
                }
            }

            // Копіюємо нову сітку в поточну.
            grid = newGrid;
        }
    }

    /**
     * Підраховує кількість живих сусідів для заданої клітинки.
     *
     * @param row Індекс рядка клітинки.
     * @param col Індекс стовпця клітинки.
     * @return Кількість живих сусідів.
     */
    private int countLiveNeighbors(int row, int col) {
        int count = 0;

        // Перебираємо 8 сусідніх клітинок.
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Пропускаємо саму клітинку.
                // Обчислюємо індекси рядка та стовпця сусіда.
                int newRow = (row + i + rows) % rows;
                int newCol = (col + j + cols) % cols;

                // Збільшуємо лічильник, якщо сусід живий.
                if (grid[newRow][newCol]) count++;
            }
        }

        return count;
    }

    /**
     * Записує кінцевий стан сітки у вихідний файл.
     *
     * @param fileName Ім'я вихідного файлу.
     * @throws IOException        Якщо виникла помилка під час запису у файл.
     * @throws URISyntaxException Якщо виникла помилка при розв'язанні шляху до файлу.
     */
    private void writeOutputFile(String fileName) throws IOException, URISyntaxException {
        // Отримуємо шлях до папки з ресурсами.
        URL resourceUrl = getClass().getClassLoader().getResource("");
        if (resourceUrl == null) {
            throw new IOException("Не вдалося знайти папку з ресурсами");
        }

        // Створюємо шлях до вихідного файлу.
        Path resourcesPath = Paths.get(resourceUrl.toURI());
        Path outputPath = resourcesPath.resolve(fileName);

        // Записуємо кінцевий стан сітки у файл.
        try (BufferedWriter bw = Files.newBufferedWriter(outputPath)) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    bw.write(grid[i][j] ? "X" : "O");
                    if (j < cols - 1) bw.write(" ");
                }
                bw.newLine();
            }
        } catch (Exception e) {
            throw new IOException("Помилка запису у файл: " + e.getMessage());
        }
    }
}

