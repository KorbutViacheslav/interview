public class OuterClass {
    private static String staticMsg = "Статичне повідомлення";

    public static class StaticNestedClass {
        public void display() {
            System.out.println("Статичний вкладений клас: " + staticMsg);
        }
    }

    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display();
    }
}