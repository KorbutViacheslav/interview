package reflection;

import java.lang.reflect.Field;

public class ReflectionExample2 {
    public static void main(String[] args) throws Exception  {

        // Створюємо об'єкт класу "Animal"
        Animal animal = new Animal();

        // Отримуємо поле "name" класу "Animal"
        Field declaredField = Animal.class.getDeclaredField("name");

        // Дозволяємо доступ до приватного поля name класу Animal
        declaredField.setAccessible(true);

        // Отримуємо значення поля name
        String name = (String) declaredField.get(animal);

        // Виводимо значення поля
        System.out.println(name);

        // Змінити значення поля
        declaredField.set(animal,"NewAnimalName");

        // Отримати оновлене значення
        String newAnimalName = (String) declaredField.get(animal);

        System.out.println(newAnimalName);

    }

}
class Animal{
    private String name = "AnimalName";
}
