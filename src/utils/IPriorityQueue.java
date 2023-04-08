package utils;

public interface IPriorityQueue<K extends Comparable<K>,V> {
    
    public void insert(K key, V value);
    public V extract();
    public void increaseKey(int i, Node<K, V> node);
}
