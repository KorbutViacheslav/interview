package linearDataStructure.staticDataStructure;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        System.out.println(array[0]); // Виведе: 1
        Arrays.stream(array).forEach(System.out::print); // Output: 12000
    }
}
