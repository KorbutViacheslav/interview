package inner.methodLocalInnerClass;

public class MethodLocalInnerClass {
    public static void main(String[] args) {
        Outer x = new Outer();
        x.outerMethod();
    }
}

class Outer {
    void outerMethod() {
        System.out.println("Outer Method");
        class Inner {
            void innerMethod() {
                System.out.println("Inner Method");
            }
        }

        Inner y = new Inner();
        y.innerMethod();
    }
}
