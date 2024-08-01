package abstractClasses;


public class Operation extends MathematicalOperations {
    //definition of abstract method
    public void add() {
        System.out.println("Sum of a and b is: " + (a + b));
    }

    public static void main(String[] args) {
        MathematicalOperations obj = new Operation();
        obj.add();
    }
}

//abstract class
abstract class MathematicalOperations {
    int a = 30, b = 40;

    //abstract method
    public abstract void add();
}