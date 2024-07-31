package inner.anonimusInnerClass;

public class AnonymousInnerClass {
    static OuterA o = new OuterA() {
        void show()
        {
            super.show();
            System.out.println("Demo class");
        }
    };

    public static void main(String[] args) { o.show(); }
}

class OuterA {
    void show()
    {
        System.out.println("Show method of super class");
    }
}
