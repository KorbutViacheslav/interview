package linearDataStructure.dynamicDataStructure.dynamicDataStructure.linkedListExample;
/**
 10 найпопулярніших методів LinkedList:
 - add(data): Додає елемент в кінець списку.
 - addFirst(data): Додає елемент на початок списку.
 - addLast(data): Додає елемент в кінець списку (синонім методу add).
 - removeFirst(): Видаляє перший елемент зі списку і повертає його значення.
 - removeLast(): Видаляє останній елемент зі списку і повертає його значення.
 - get(index): Повертає елемент за заданим індексом.
 - size(): Повертає кількість елементів у списку.
 - contains(data): Перевіряє, чи містить список елемент з заданим значенням.
 - clear(): Видаляє всі елементи зі списку.
 - iterator(): Повертає ітератор для перебору елементів списку.
 */
public class LinkedListExample {
    Node head; // Перший елемент списку
    Node tail; // Останній елемент списку
    // Метод для додавання елемента в кінець списку
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }
    }

    // ... інші методи
}
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}