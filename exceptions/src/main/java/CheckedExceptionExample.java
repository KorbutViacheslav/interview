import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        File file = new File("nonexistent.txt");
        try {
            FileReader fr = new FileReader(file);
        } catch (IOException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        } finally {
            System.out.println("Цей блок виконається в будь-якому випадку");
        }
    }
}