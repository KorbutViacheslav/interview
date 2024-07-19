public class Logarithmic {
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
}
