package utils;

public class Data {

    public static <T extends Comparable<T>> void quicksort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = middle(array, left, right);
            quicksort(array, left, pivot - 1);
            quicksort(array, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int middle(T[] array, int left, int right) {
        T pivot = array[left];
        while (left < right) {
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            while (array[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left < right) {
                T temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return left;
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