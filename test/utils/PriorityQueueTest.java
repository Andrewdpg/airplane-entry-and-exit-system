package test.utils;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;

import org.junit.Test;

import utils.MaxHeap;
import utils.Node;

public class PriorityQueueTest {

    private MaxHeap<String> heap;

    public void setupEmptyHeap() {
        heap = new MaxHeap<>(10);
    }

    public void setupFullCapacityHeap() {
        heap = new MaxHeap<>(4);

        heap.insert(60.0, "C");
        heap.insert(100.0, "A");
        heap.insert(40.0, "D");
        heap.insert(80.0, "B");
    }

    @Test
    public void insertingEmptyTest() {
        setupEmptyHeap();

        heap.insert(60.0, "C");
        heap.insert(100.0, "A");
        heap.insert(40.0, "D");
        heap.insert(80.0, "B");

        assertEquals("[{100.0,A}, {80.0,B}, {40.0,D}, {60.0,C}, null, null, null, null, null, null]",
                Arrays.toString(heap.gett()));
        assertEquals(4, heap.size());
    }

    @Test
    public void insertFullCapacityTest() {
        setupFullCapacityHeap();

        assertThrows(IndexOutOfBoundsException.class, () -> heap.insert(101.0, "E"));
    }

    @Test
    public void extractTest() {
        setupEmptyHeap();

        heap.insert(60.0, "C");
        heap.insert(100.0, "A");
        heap.insert(40.0, "D");
        heap.insert(80.0, "B");

        assertEquals("A", heap.extract());
        assertEquals(3, heap.size());
    }

    @Test 
    public void extractEmptyTest() {
        setupEmptyHeap();

        assertNull(heap.extract());
    }

    @Test
    public void heapsortTest() {
        setupFullCapacityHeap();

        Node<Double, String>[] result = heap.heapSort();

        assertEquals("[{40.0,D}, {60.0,C}, {80.0,B}, {100.0,A}]", Arrays.toString(result));
    }
}
