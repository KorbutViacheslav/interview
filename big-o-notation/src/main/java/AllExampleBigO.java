import java.util.Arrays;

public class AllExampleBigO {
    public static void main(String[] args) {
        //Константа - О(1)
        System.out.println(Constant.sum(2,5));
        System.out.println(Constant.isEven(3));

        //Злиття - О(log N)
        int[] ar1 = {1,3,5,7};
        int[] ar2 = {2,4,6,8};
        Arrays.stream(merge(ar1,ar2)).forEach(System.out::println);
    }

    // O(1)
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


    // O(log N)

    //Пошук елемента в сортованому масиві за допомогою бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    //Злиття двох сортованих масивів
    public static int[] merge(int[] array1, int[] array2) {
        // Створення нового масиву `result` для зберігання результату злиття
        int[] result = new int[array1.length + array2.length];

        // Ініціалізація лічильників
        int i = 0;
        int j = 0;
        int k = 0;

        // Основний цикл злиття
        while (i < array1.length && j < array2.length) {
            // Порівняння елементів з двох масивів
            if (array1[i] <= array2[j]) {
                // Додати елемент з array1 до result
                result[k++] = array1[i++];
            } else {
                // Додати елемент з array2 до result
                result[k++] = array2[j++];
            }
        }

        // Обробка залишків елементів з array1
        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        // Обробка залишків елементів з array2
        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        // Повернення відсортованого масиву result
        return result;
    }


    // O(N)

    //Лінійний пошук елемента в масиві
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    //Обчислення суми елементів масиву
    public static int sumArrayElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
    //Реверсування масиву
    public static void reverseArray(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
