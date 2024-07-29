import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line = br.readLine();
            int number = Integer.parseInt(line);
            System.out.println("Прочитане число: " + number);
        } catch (IOException e) {
            System.out.println("Помилка вводу-виводу: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Помилка перетворення рядка в число: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла інша помилка: " + e.getMessage());
        }
    }
}