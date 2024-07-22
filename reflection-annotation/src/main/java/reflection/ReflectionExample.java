package reflection;

import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception  {

        // Створюємо об'єкт класу "String"
        String str = "Hello, world!";

        // Отримуємо метод "toUpperCase" класу "String"
        Method method = String.class.getMethod("toUpperCase");

        // Викликаємо метод "toUpperCase" для об'єкта "str"
        String result = (String) method.invoke(str);

        // Виводимо результат
        System.out.println(result);
    }

}
