package annotation.example2;
// Оголошення нової анотації
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

