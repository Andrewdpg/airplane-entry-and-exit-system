package utils;

import java.util.LinkedList;

public class HashTable<K extends Comparable<K>, V> {

    private LinkedList<Node<K, V>>[] table;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<Node<K, V>>();
        }
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = table[index];
        for (Node<K, V> node : list) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        list.add(new Node<K, V>(key, value));
        size++;
        if (size > DEFAULT_LOAD_FACTOR * table.length) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = table[index];
        for (Node<K, V> node : list) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = table[index];
        for (Node<K, V> node : list) {
            if (node.getKey().equals(key)) {
                list.remove(node);
                size--;
                return node.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = table[index];
        for (Node<K, V> node : list) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public Node<K, V>[] toArray(){
        Node<K, V>[] array = new Node[size];
        int index = 0;
        for (LinkedList<Node<K,V>> list : table) {
            for (Node<K, V> node : list) {
                array[index] = node;
                index++;
            }
        }
        Data.quicksort(array);
        return array;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Node<K, V>>[] oldTable = table;
        table = new LinkedList[2 * oldTable.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<Node<K, V>>();
        }
        size = 0;
        for (LinkedList<Node<K, V>> list : oldTable) {
            for (Node<K, V> Node : list) {
                put(Node.getKey(), Node.getValue());
            }
        }
    }
}