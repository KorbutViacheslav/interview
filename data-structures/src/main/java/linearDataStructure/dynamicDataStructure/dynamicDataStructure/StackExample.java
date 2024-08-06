package linearDataStructure.dynamicDataStructure.dynamicDataStructure;

/**
 * What is a stack?
 * <p>
 * A stack is a representation of nodes. There are two components to each node:
 * data and next (storing address of next node). Each node’s data portion contains the assigned value,
 * and its next pointer directs the user to the node that has the stack’s subsequent item.
 * The highest node in the stack is referred to as the top.
 * Features of Stack
 * Linear Data Structures using Java
 * Follows LIFO: Last In First Out
 * Only the top elements are available to be accessed
 * Insertion and deletion takes place from the top
 * Eg: a stack of plates, chairs, etc
 * 4 major operations:
 * push(ele) – used to insert element at top
 * pop() – removes the top element from stack
 * isEmpty() – returns true is stack is empty
 * peek() – to get the top element of the stack
 * All operation works in constant time i.e, O(1)
 * <p>
 * Stack Advantages
 * <p>
 * Maintains data in a LIFO manner
 * The last element is readily available for use
 * All operations are of O(1) complexity
 * <p>
 * Stack Disadvantages
 * <p>
 * Manipulation is restricted to the top of the stack
 * Not much flexible
 */
public class StackExample {

    int[] a;
    int top;

    StackExample() {
        a = new int[100];
        top = -1;
    }
    //Додає новий елемент на верхівку стеку
    void push(int x) {
        if (top == a.length - 1)
            System.out.println("overflow");
        else
            a[++top] = x;
    }
    //Видаляє верхній елемент і повертає його значення
    int pop() {
        if (top == -1) {
            System.out.println("underflow");
            return -1;
        } else
            return (a[top--]);
    }
    //Виводить весь вміст стеку
    void display() {
        for (int i = 0; i <= top; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    //Перевіряє, чи є в стеку елементи
    boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }
    //Дивиться на верхній елемент, але не видаляє його
    int peek() {
        if (top == -1)
            return -1;
        return (a[top]);
    }

    public static void main(String[] args) {
        StackExample stack = new StackExample();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Елементи стеку:");
        stack.display();

        int x = stack.pop();
        System.out.println("Видалений елемент: " + x);

        System.out.println("Чи стек порожній? " + stack.isEmpty());
    }

}
