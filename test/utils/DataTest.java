package test.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import utils.Data;

public class DataTest {

    Integer[] array;

    public void setupUnordered() {
        array = new Integer[] { 6, 1, 7, 3, 2, 9, 8, 5, 10, 4 };
    }

    public void setupUnorderedNegative() {
        array = new Integer[] { -5, 3, 1, 4, -2, -3, 5, -1, 2, -4, 0 };
    }

    public void setupOrdered() {
        array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    }

    public void setupOrderedLargeData() {
        array = new Integer[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    @Test
    public void sortingTest() {
        setupUnordered();
        Data.quicksort(array);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(array));

        setupUnorderedNegative();
        Data.quicksort(array);
        assertEquals("[-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }

    @Test
    public void searchTest() {
        setupOrdered();
        int position = Data.binarySearch(array, 7);
        assertEquals(6, position);
    }

    @Test
    public void searchTimeTest() {
        setupOrderedLargeData();
        Long initTime = System.currentTimeMillis();
        int position = Data.binarySearch(array, 999997);
        Long totalTime = System.currentTimeMillis() - initTime;
        assertTrue(totalTime < 10 && position == 999997);
    }
}
