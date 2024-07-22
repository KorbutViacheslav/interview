package annotation.example1;

import java.lang.annotation.Annotation;

public class AnnotationExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();

        // Отримуємо інформацію про аннотацію класу MyClass
        Class<?> clazz = obj.getClass();
        Annotation annotation = clazz.getAnnotation(ClassInfo.class);
        if (annotation instanceof ClassInfo) {
            ClassInfo classInfo = (ClassInfo) annotation;
            System.out.println("Class Name: " + classInfo.name());
            System.out.println("Class Version: " + classInfo.version());
        }
    }

}
