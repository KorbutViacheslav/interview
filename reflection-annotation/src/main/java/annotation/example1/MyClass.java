package annotation.example1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface ClassInfo {
    String name();
    double version();
}

@ClassInfo(name = "MyClass", version = 1.0)
class MyClass {

    public void display() {
        System.out.println("This is MyClass.");
    }
}

