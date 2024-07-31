package inner.staticNestedClass;

public class StaticNestedClass {
    static int data = 100;

    static class Inner {

        void msg() {
            System.out.println("data is " + data);
        }
    }

    public static void main(String[] args) {
        StaticNestedClass.Inner obj = new StaticNestedClass.Inner();
        obj.msg();
    }
}
