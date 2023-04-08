package test.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import utils.HashTable;
import utils.Node;

public class HashTableTest {

    private HashTable<String, Integer> table;

    public void setupEmpty() {
        table = new HashTable<>();
    }

    public void setupFiled() {
        table = new HashTable<>();

        table.put("David", 20);
        table.put("Rosa", 19);
        table.put("Jose", 18);
        table.put("Karen", 20);
    }

    @Test
    public void getTest() {
        setupFiled();

        assertTrue(table.containsKey("David"));
        assertEquals(20, table.get("David"));
    }

    @Test
    public void putTest() {
        setupEmpty();

        table.put("David", 20);

        assertTrue(table.containsKey("David"));
        assertEquals(20, table.get("David"));
    }

    @Test
    public void putRepeatedKeyTest() {
        setupFiled();

        table.put("David", 21);

        assertEquals(21, table.get("David"));
        assertEquals(4, table.size());
    }

    @Test
    public void removeTest() {
        setupFiled();

        table.remove("David");

        assertFalse(table.containsKey("David"));
        assertNull(table.get("David"));
        assertEquals(3, table.size());
    }

    @Test
    public void toArrayTest() {
        setupFiled();

        Node<String, Integer>[] array = table.toArray();
        
        assertEquals("[{David,20}, {Jose,18}, {Karen,20}, {Rosa,19}]", Arrays.toString(array));
    }
}
