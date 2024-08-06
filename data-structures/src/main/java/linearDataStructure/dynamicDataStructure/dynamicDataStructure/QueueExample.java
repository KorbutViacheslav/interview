package linearDataStructure.dynamicDataStructure.dynamicDataStructure;
/**
 * What is Queue?
 * The queue is called an abstract data structure. Data is always added to one end (enqueued),
 * and removed from the other (dequeue).
 * Queue uses the First-In-First-Out approach and data item that was stored initially will be
 * accessed first in a queue.
 * Features of Queue
 *     Linear Data Structure
 *     Follows FIFO: First In First Out
 *     Insertion can take place from the rear end.
 *     Deletion can take place from the front end.
 *     Eg: queue at ticket counters, bus station
 *     4 major operations:
 *         enqueue(ele) – used to insert element at top
 *         dequeue() – removes the top element from queue
 *         peekfirst() – to get the first element of the queue
 *         peeklast() – to get the last element of the queue
 *     All operation works in constant time i.e, O(1)
 *
 * Queue Advantages
 *
 *     Maintains data in FIFO manner
 *     Insertion from beginning and deletion from end takes O(1) time
 *
 * Queue Applications
 *
 *     Scheduling
 *     Maintaining playlist
 *     Interrupt handling
 *
 * Variations in Queue: Two popular variations of queues are Circular queues and Dequeues.
 *
 * Що таке черга? Черга називається абстрактною структурою даних.
 * Дані завжди додаються в один кінець (поставляються в чергу) і видаляються з іншого (виключено з черги).
 * У черзі використовується підхід «першим прийшов – першим вийшов», а елемент даних,
 * який було збережено спочатку, буде доступний першим у черзі. Особливості черги.
 * Лінійна структура даних відповідає FIFO: вставлення першим прийшов, першим вийшов,
 * може відбуватися із заднього кінця. Видалення може відбуватися з інтерфейсу.
 * Наприклад: черга біля квиткових кас, автобусна станція 4 основні операції:
 * enqueue(ele) – використовується для вставки елемента вгору
 * dequeu()– видаляє верхній елемент із черги
 * peekfirst() – щоб отримати перший елемент черги
 * peeklast()– для отримання останнього елемента черги. Усі операції працюють у постійному часі,
 * тобто O(1) Переваги черги Зберігає дані у формі FIFO Вставлення з початку та видалення
 * з кінця займає O(1) часу Планування програм у черзі Ведення списку відтворення Обробка переривань
 * Варіації в черзі : Дві популярні варіації черг – кругові черги та дечерги.
 */
public class QueueExample {

    int front;//Індекс першого елемента в черзі.
    int rear;//Індекс останнього елемента в черзі.
    int[] arr;//Масив для зберігання елементів черги.

    QueueExample() {
        front=rear=-1;
        arr=new int[10];
    }
    //Додає елемент в кінець черги. Перевіряє, чи черга не переповнена.
    //Збільшує rear і поміщає новий елемент в кінець. Якщо черга була порожня, то встановлює front в 0.
    void enqueue(int a) {
        if(rear==arr.length-1)
            System.out.println("overflow");
        else
            arr[++rear]=a;

        if(front==-1)
            front++;
    }
    //Видаляє і повертає елемент з початку черги.
    //    Перевіряє, чи черга не порожня.
    //    Зберігає значення першого елемента в змінну x.
    //    Збільшує front, щоб вказати на наступний елемент.
    //    Якщо після видалення елемента черга стала порожньою, то встановлює rear в -1.
    int dequeue() {
        int x=-1;
        if(front==-1)
            System.out.println("underflow");
        else
            x=arr[front++];
        if(rear==0)
            rear--;
        return x;
    }
    //Виводить всі елементи черги на екран.
    void display() {
        for(int i=front;i<=rear;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        QueueExample queue = new QueueExample();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Елементи черги:");
        queue.display();
        int x = queue.dequeue();
        System.out.println("Видалений елемент: " + x);
        System.out.println("Елементи черги після видалення:");
        queue.display();
    }
}
