package utils;

public class Data {

    public static <T extends Comparable<T>> void quicksort(T[] array) {
        if (array == null) {
            return;
        }
        quicksort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quicksort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = middle(array, left, right);
            quicksort(array, left, pivot - 1);
            quicksort(array, pivot + 1, right);
        }
    }
    
    private static <T extends Comparable<T>> int middle(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T value) {
        int a = 0;
        int b = array.length - 1;
        while (a <= b) {
            int mid = a + (b - a) / 2;
            if (value.compareTo(array[mid]) == 0) {
                return mid;
            } else if (value.compareTo(array[mid]) < 0) {
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }
        return -1;
    }
}