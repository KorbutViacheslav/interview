package reflection;

import java.lang.reflect.Method;

public class ReflectionExample3 {
    public static void main(String[] args) throws Exception  {

        // Отримуємо клас "String"
        Class<?> stringClass = String.class;

        // Виводимо ім'я класу
        System.out.println("Class name: " + stringClass.getName());

        // Отримуємо всі методи класу "String"
        Method[] methods = stringClass.getMethods();

        // Виводимо список методів
        System.out.println("Methods:");

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

}
