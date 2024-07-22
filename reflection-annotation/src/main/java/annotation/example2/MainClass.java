package annotation.example2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Example");

        // Дістаємо анотації класу за допомогою рефлексії
        Class<MyClass> obj = MyClass.class;
        Annotation[] classAnnotations = obj.getAnnotations();
        for (Annotation annotation : classAnnotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("Анотація класу: " + myAnnotation.value());
            }
        }

        // Дістаємо анотації методу за допомогою рефлексії
        try {
            Method method = obj.getMethod("myMethod");
            Annotation[] methodAnnotations = method.getAnnotations();
            for (Annotation annotation : methodAnnotations) {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("Анотація методу: " + myAnnotation.value());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

