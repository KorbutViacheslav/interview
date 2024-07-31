package inner.anonimusInnerClass;
//Example 2: Using Interface
public class AnonymousInnerClass2 {
    static Hello h = new Hello() {
        public void show()
        {
            System.out.println(
                    "This is an anonymous class");
        }
    };

    public static void main(String[] args) { h.show(); }
}

interface Hello {
    void show();
}