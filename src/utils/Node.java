package utils;

public class Node<K extends Comparable<K>, V> implements Comparable<Node<K,V>>{

    private K key;
    private V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + "," + value.toString() + "}";
    }

    @Override
    public int compareTo(Node<K, V> o) {
        return key.compareTo(o.getKey());
    }

}
