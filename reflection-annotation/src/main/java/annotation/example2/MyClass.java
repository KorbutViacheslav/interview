package annotation.example2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Оголошення нової анотації
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotation {
    String value();
}

// Використання анотації на рівні класу
@MyAnnotation(value = "Це моя перша анотація")
public class MyClass {
    // Код класу

    // Метод, який використовує анотацію
    @MyAnnotation(value = "Це мій перший метод")
    public void myMethod() {
        // Код методу
    }
}

