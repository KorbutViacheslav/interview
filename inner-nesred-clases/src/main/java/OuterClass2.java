public class OuterClass2 {
    private String msg = "Повідомлення з зовнішнього класу";

    class InnerClass {
        public void display() {
            System.out.println("Внутрішній клас: " + msg);
        }
    }

    public void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }

    public static void main(String[] args) {
        OuterClass2 outer = new OuterClass2();
        outer.createInner();

        // Альтернативний спосіб створення об'єкту внутрішнього класу
        OuterClass2.InnerClass innerObject = outer.new InnerClass();
        innerObject.display();
    }
}